package server;

import pojo.Client;
import pojo.Remote;

import java.util.Hashtable;
import java.util.Map;

public class SocketContainer {
    private static final SocketContainer instance = new SocketContainer();
    private Map<Integer, Remote> remoteContainer;
    private Map<Integer, Client> clientContainer;
    private SocketContainer() {
        remoteContainer = new Hashtable<>();
        clientContainer = new Hashtable<>();
    }

    public static SocketContainer getInstance() {
        return instance;
    }

    public void addRemoteConnection(Remote remote) {
        remoteContainer.put(remote.getId(), remote);
    }

    public void addClientConnection(Client client) {
        clientContainer.put(client.getClient_id(), client);
    }

    public Remote getRemoteByIdPwd(int id, String pwd) {
        Remote remote = remoteContainer.get(id);
        if (remote == null) {
            return null;
        }
        if (remote.getPassword().equals(pwd)) {
            return remote;
        }
        return null;
    }


}
