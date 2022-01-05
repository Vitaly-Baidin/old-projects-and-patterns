import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        Authentication andreiK = new Authentication("", "");
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        TableCSV tableCSV = new TableCSV(4);
        String domainName;
        StringBuilder domainNS;
        String domainExpirationDate;
        String ownerName;
        String isPrivateAcc;

        String JSONDomains = andreiK.getJSONDomains();
        System.out.println("Authentication SUCCESS");

        FileWriter csvWriter = new FileWriter("/home/vitalyb/Downloads/new2.csv");

        try {
            JSONObject jsonObject = new JSONObject(JSONDomains);
            System.out.println("create JSON file SUCCESS");
            JSONArray domains = jsonObject.getJSONArray("items");


            for (int i = 0; i < domains.length(); i++) {
                JSONObject tmpObject = domains.getJSONObject(i);
                domainNS = new StringBuilder();

                Date date = new Date(Long.parseLong(tmpObject.get("expiration_date").toString() + "000"));

                domainExpirationDate = formatter.format(date) + ",";
                domainName = tmpObject.get("domain").toString() + ",";

                if (tmpObject.getJSONObject("data").getJSONObject("details").has("person")) {
                    ownerName = tmpObject.getJSONObject("data").getJSONObject("details").get("person").toString() + ",";
                } else if (tmpObject.getJSONObject("data").getJSONObject("details").has("a_first_name")){
                    ownerName = tmpObject.getJSONObject("data").getJSONObject("details").get("a_first_name").toString() + " " + tmpObject.getJSONObject("data").getJSONObject("details").get("a_last_name").toString() + ",";
                } else {
                    ownerName = tmpObject.getJSONObject("order_data").get("first_name").toString() + " " + tmpObject.getJSONObject("order_data").get("last_name").toString() + ",";
                }

                if (Objects.equals(tmpObject.get("ns_servers").toString(), "null")) {
                    domainNS.append(",,,,");
                } else {
                    JSONArray tmpNS = tmpObject.getJSONArray("ns_servers");
                    int help = 4 - tmpNS.length();
                    for (int j = 0; j < tmpNS.length(); j++) {
                        JSONObject tmpNSObject = tmpNS.getJSONObject(j);
                        domainNS.append(tmpNSObject.get("ns").toString()).append(",");
                    }
                    domainNS.append(",".repeat(Math.max(0, help)));
                }
                if(!tmpObject.getJSONObject("data").has("private_person_flag")) {
                    isPrivateAcc = "true";
                } else {
                    isPrivateAcc = "false";
                }

                tableCSV.addRow(domainName + domainNS + domainExpirationDate + ownerName + isPrivateAcc);
            }
        }catch (JSONException err){
            err.getLocalizedMessage();
        }

        for (String elem : tableCSV.getRows()) {
            csvWriter.append(elem);
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
