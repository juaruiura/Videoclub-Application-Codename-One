/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.layouts.BoxLayout.X_AXIS;
import static com.codename1.ui.layouts.BoxLayout.Y_AXIS;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 * GUI builder created Form
 *
 * @author Juan Manuel
 */
public class FormPeliculas extends com.codename1.ui.Form {
    
    Container listPeliculas;
    boolean editar = false;
    
    public FormPeliculas() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        //Change layout from Layered to Box
        this.setLayout(new BoxLayout(Y_AXIS));
        //Add back button to go back to login
        this.getToolbar().setBackCommand("", e -> new FormLogin().showBack());
        //Container where we'll be adding the films
        listPeliculas = new Container(new BoxLayout(Y_AXIS));
        //Tabs with the locations
        Tabs tabs = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ADD_LOCATION, s);
        Container escaleritas = new Container(new BoxLayout(Y_AXIS));
        escaleritas.add(new Label("Las Palmas de Gran Canaria"));
        escaleritas.add(new Label("Escalertias, 4"));
        escaleritas.add(new Label("Horario: 9:00-21:00"));
        Container pedroinfinito = new Container(new BoxLayout(Y_AXIS));
        pedroinfinito.add(new Label("Las Palmas de Gran Canaria"));
        pedroinfinito.add(new Label("Pedro Infinito, 6"));
        pedroinfinito.add(new Label("Horario: 8:00-20:00"));
        tabs.addTab("Escaleritas", icon, escaleritas);
        tabs.addTab("Pedro Infinito", icon, pedroinfinito);
        //Add components
        this.addComponent(0, new Label("Dirección de nuestros locales"));
        this.addComponent(1,tabs);
        this.addComponent(2, new Label("Formulario Películas"));
        
        
    }
    
    public FormPeliculas(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_tituloTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_generoTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_sinopsisTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_duracionTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_stockTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_ButtonAlta = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_ButtonListar = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_ButtonAlta.addActionListener(callback);
        gui_ButtonListar.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_ButtonAlta) {
                onButtonAltaActionEvent(ev);
            }
            if(sourceComponent == gui_ButtonListar) {
                onButtonListarActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Videoclub");
        setName("FormPeliculas");
        addComponent(gui_Label);
        addComponent(gui_tituloTextField);
        addComponent(gui_Label_1);
        addComponent(gui_generoTextField);
        addComponent(gui_Label_2);
        addComponent(gui_sinopsisTextField);
        addComponent(gui_Label_3);
        addComponent(gui_duracionTextField);
        addComponent(gui_Label_4);
        addComponent(gui_stockTextField);
        addComponent(gui_ButtonAlta);
        addComponent(gui_ButtonListar);
        gui_Label.setText("T\u00EDtulo:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "3.7037036mm auto auto 31.034483%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
                gui_tituloTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_tituloTextField.setName("tituloTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tituloTextField.getParent().getLayout()).setInsets(gui_tituloTextField, "6.9970846% auto auto 21.521997%").setReferenceComponents(gui_tituloTextField, "-1 -1 -1 -1").setReferencePositions(gui_tituloTextField, "0.0 0.0 0.0 0.0");
        gui_Label_1.setText("G\u00E9nero:");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "14.285714% auto auto 31.74792%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
                gui_generoTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_generoTextField.setName("generoTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_generoTextField.getParent().getLayout()).setInsets(gui_generoTextField, "18.075802% auto auto 21.521996%").setReferenceComponents(gui_generoTextField, "-1 -1 -1 -1").setReferencePositions(gui_generoTextField, "0.0 0.0 0.0 0.0");
        gui_Label_2.setText("Sinopsis:");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "24.489796% auto auto 30.79667%").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
                gui_sinopsisTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_sinopsisTextField.setName("sinopsisTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sinopsisTextField.getParent().getLayout()).setInsets(gui_sinopsisTextField, "28.279882% auto auto 21.403091%").setReferenceComponents(gui_sinopsisTextField, "-1 -1 -1 -1").setReferencePositions(gui_sinopsisTextField, "0.0 0.0 0.0 0.0");
        gui_Label_3.setText("Duraci\u00F3n:");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "33.67347% auto auto 31.034483%").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
                gui_duracionTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_duracionTextField.setName("duracionTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_duracionTextField.getParent().getLayout()).setInsets(gui_duracionTextField, "38.338192% auto auto 20.808561%").setReferenceComponents(gui_duracionTextField, "-1 -1 -1 -1").setReferencePositions(gui_duracionTextField, "0.0 0.0 0.0 0.0");
        gui_Label_4.setText("Stock:");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "44.023323% auto auto 31.74792%").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
                gui_stockTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_stockTextField.setName("stockTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_stockTextField.getParent().getLayout()).setInsets(gui_stockTextField, "auto auto 47.521866% 19.024971%").setReferenceComponents(gui_stockTextField, "-1 -1 -1 -1").setReferencePositions(gui_stockTextField, "0.0 0.0 0.0 0.0");
        gui_ButtonAlta.setText("Dar de alta");
                gui_ButtonAlta.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonAlta.setName("ButtonAlta");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonAlta.getParent().getLayout()).setInsets(gui_ButtonAlta, "auto auto 32.653164% 31.034483%").setReferenceComponents(gui_ButtonAlta, "-1 -1 -1 -1").setReferencePositions(gui_ButtonAlta, "0.0 0.0 0.0 0.0");
        gui_ButtonListar.setText("Listar pel\u00EDculas");
                gui_ButtonListar.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonListar.setName("ButtonListar");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonListar.getParent().getLayout()).setInsets(gui_ButtonListar, "auto auto 26.239113% 31.034483%").setReferenceComponents(gui_ButtonListar, "-1 -1 -1 -1").setReferencePositions(gui_ButtonListar, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    //Method used to load the data from the film table in the database and print it on the app
    public void mostrarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            Map<String, Object> data;
            @Override
            protected void postResponse() {
                listPeliculas.removeAll();
                c.getComponentForm().revalidate();
                java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>)data.get("root");
                Button hideListPeliculas = new Button("Esconder listado");
                hideListPeliculas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        listPeliculas.removeAll();
                        c.getComponentForm().revalidate();
                    }
                });
                listPeliculas.addComponent(hideListPeliculas);
                for(Map<String, Object> obj : content) {
                    String titulo = (String)obj.get("titulo");
                    String genero = (String)obj.get("genero");
                    String sinopsis = (String)obj.get("sinopsis");
                    double duracion = (Double)obj.get("duracion");
                    double stock = (Double)obj.get("stock");
                    Container row = new Container(new BoxLayout(X_AXIS));
                    Button buttonBorrar = new Button("Borrar");
                    buttonBorrar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ev) {
                            borrarDatos(ev.getComponent(), titulo);
                        }
                    });
                    row.addComponent(buttonBorrar);
                    Button buttonEditar = new Button("Editar");
                    buttonEditar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ev) {
                            cargarDatos(ev.getComponent(), titulo);
                            gui_ButtonAlta.setText("Guardar");
                            editar=true;
                        }
                    });
                    row.addComponent(buttonEditar);
                    listPeliculas.addComponent(new Label(titulo));
                    listPeliculas.addComponent(new Label("Género: " + genero));
                    listPeliculas.addComponent(new Label("Sinopsis:"));
                    listPeliculas.addComponent(new Label(sinopsis));
                    listPeliculas.addComponent(new Label("Duración: " + duracion));
                    listPeliculas.addComponent(new Label("Stock: " + stock));
                    listPeliculas.addComponent(row);
                }
                if(c.getComponentForm().contains(listPeliculas)==false)
                    c.getComponentForm().addComponent(listPeliculas);
                c.getComponentForm().revalidate();
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                JSONParser p = new JSONParser();
                data = p.parseJSON(new InputStreamReader(input));
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/findAll");
        r.setPost(false);
        r.addArgument("q", "@codename-one");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method to create a new film in the database
    public void enviarDatos(){
        ConnectionRequest r = new ConnectionRequest(){
            JSONObject json = new JSONObject();

            protected void buildRequestBody(OutputStream os) throws IOException {
                json.put("titulo", gui_tituloTextField.getText());
                json.put("genero", gui_generoTextField.getText());
                json.put("sinopsis", gui_sinopsisTextField.getText());
                json.put("duracion", gui_duracionTextField.getText());
                json.put("stock", gui_stockTextField.getText());
                os.write(json.toString().getBytes("UTF-8"));
                cleanTextFields();
            }
            
            @Override
            protected void readResponse(InputStream input) throws IOException {
                
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/post");
        r.setPost(true);
        r.setContentType("application/json");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method used to delete a film from the database
    public void borrarDatos(Component c, String id){
        ConnectionRequest r = new ConnectionRequest(){
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/delete/"+id);
        r.setPost(false);
        r.setHttpMethod("DELETE");
        r.addArgument("q", "@codename-one");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method used to load the data of a film into the inputs and sets the create button to edit
    public void cargarDatos(Component c, String id){
        ConnectionRequest r = new ConnectionRequest(){
            Hashtable data;
            @Override
            protected void postResponse() {
                gui_tituloTextField.setText(data.get("titulo").toString());
                gui_generoTextField.setText(data.get("genero").toString());
                gui_sinopsisTextField.setText(data.get("sinopsis").toString());
                int duracionIntFormatted = Double.valueOf(data.get("duracion").toString()).intValue();
                gui_duracionTextField.setText(String.valueOf(duracionIntFormatted));
                int stockIntFormatted = Double.valueOf(data.get("stock").toString()).intValue();
                gui_stockTextField.setText(String.valueOf(stockIntFormatted));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                JSONParser p = new JSONParser();
                data = p.parse(new InputStreamReader(input));
            }
            
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/find/"+id);
        r.setPost(false);
        r.addArgument("q", "@codename-one");
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method used to edit data from a film and switch the create button to normal afterwards
    public void editarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            JSONObject json = new JSONObject();

            protected void buildRequestBody(OutputStream os) throws IOException {
                json.put("genero", gui_generoTextField.getText());
                json.put("sinopsis", gui_sinopsisTextField.getText());
                json.put("duracion", gui_duracionTextField.getText());
                json.put("stock", gui_stockTextField.getText());
                os.write(json.toString().getBytes("UTF-8"));
                cleanTextFields();
            }
            
            @Override
            protected void readResponse(InputStream input) throws IOException {
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/put/" + gui_tituloTextField.getText());
        r.setContentType("application/json");
        r.setPost(true);
        r.setHttpMethod("PUT");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method used to validate that the inputs aren't empty and the duration and stock inputs are numeric
    private boolean validar(){
        if(gui_tituloTextField.getText().compareTo("")==0){
            return false;
        }
        if(gui_generoTextField.getText().compareTo("")==0){
            return false;
        }
        if(gui_sinopsisTextField.getText().compareTo("")==0){
            return false;
        }
        if(gui_duracionTextField.getText().compareTo("")==0  || !isNumeric(gui_duracionTextField.getText())){
            return false;
        }
        if(gui_stockTextField.getText().compareTo("")==0 || !isNumeric(gui_stockTextField.getText())){
            return false;
        }
        return true;
    }
    
    //Method to check if the given str is a number
    private boolean isNumeric(String str){
        try {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe) {  
          return false;  
        }  
        return true;  
    }
    
    //Method to clean the input fields
    private void cleanTextFields(){
        gui_tituloTextField.clear();
        gui_generoTextField.clear();
        gui_sinopsisTextField.clear();
        gui_duracionTextField.clear();
        gui_stockTextField.clear();
    }
    
    //Listeners for the buttons
    public void onButtonListarActionEvent(com.codename1.ui.events.ActionEvent ev) {
        mostrarDatos(ev.getComponent());
    }

    public void onButtonAltaActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if(validar()){
            if(editar){
                editarDatos(ev.getComponent());
                gui_ButtonAlta.setText("Dar de alta");
                editar=false;
            }
            else
                enviarDatos();
        }else{
            new Dialog().show("¡Uy!", "Recuerda rellenar todos los campos y que stock y duración solo deben contener un número.", "Entiendo", "Volver");
        }
    }

}
