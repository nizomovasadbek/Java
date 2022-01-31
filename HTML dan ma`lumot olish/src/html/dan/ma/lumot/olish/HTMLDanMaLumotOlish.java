package html.dan.ma.lumot.olish;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HTMLDanMaLumotOlish extends JApplet {
    
    private HashMap<String, URL> webSaytMalumot;
    private ArrayList<String> sarlavhalar;
    private JList<String> asosiyRoyxatlar;
    
    @Override
    public void init(){
        webSaytMalumot = new HashMap<>();
        sarlavhalar = new ArrayList<>();
        
        bringInformationsFromHTML();
        
        add(new JLabel("Qaysi web saytga kirmoqchisiz?"), BorderLayout.NORTH);
        
        asosiyRoyxatlar = new JList(sarlavhalar.toArray());
        asosiyRoyxatlar.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String royhat = asosiyRoyxatlar.getSelectedValue();
                URL yangiHujjat = webSaytMalumot.get(royhat);
                AppletContext brauzer = getAppletContext();
                brauzer.showDocument(yangiHujjat);
            }
        });
        add(new JScrollPane(asosiyRoyxatlar), BorderLayout.CENTER);
    }
    public void bringInformationsFromHTML(){
        String contents, address;
        URL WebAddress;
        int counting = 0;
        
        contents = getParameter("Sarlavha" + counting);
        while(contents != null){
            address = getParameter("Manzil" + counting);
            try {
                WebAddress = new URL(address);
                webSaytMalumot.put(contents, WebAddress);
                sarlavhalar.add(contents);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            ++counting;
            contents = getParameter("Sarlavha" + counting);
        }
    }
}