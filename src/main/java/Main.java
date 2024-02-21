public class Main {
    public static void main(String[] args) {
        new Thread(GameServer::listen).start();
        new Thread(ClientSeeksGame::connect).start();
    }
}
