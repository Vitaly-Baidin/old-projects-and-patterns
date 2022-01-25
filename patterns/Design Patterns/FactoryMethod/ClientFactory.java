public class ClientFactory extends PersonFactory {

    @Override
    public Client createPerson() {
        System.out.println("Создан новый клиент");
        return new Client();
    }
}
