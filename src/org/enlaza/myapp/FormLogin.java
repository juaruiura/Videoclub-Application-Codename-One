/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.layouts.BoxLayout.Y_AXIS;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Hashtable;
import org.json.simple.JSONObject;

/**
 * GUI builder created Form
 *
 * @author AlumnoTarde
 */
public class FormLogin extends com.codename1.ui.Form {
    //Variables used to store user data to compare with input data
    String usuario = "";
    String password = "";

    public FormLogin() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        //Change layout from Layered to Box
        this.setLayout(new BoxLayout(Y_AXIS));
        //Navigation between login and register form
        this.getToolbar().addMaterialCommandToSideMenu("Login", FontImage.MATERIAL_PEOPLE, e -> showLogin());
        this.getToolbar().addMaterialCommandToSideMenu("Registro", FontImage.MATERIAL_PEOPLE, e -> showRegistro());
    }
    
    public FormLogin(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_usuarioTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_passwordTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_buttonLogin = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_buttonLogin.addActionListener(callback);
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

            if(sourceComponent == gui_buttonLogin) {
                onbuttonLoginActionEvent(ev);
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
        setTitle("Login");
        setName("FormLogin");
        addComponent(gui_Label);
        addComponent(gui_usuarioTextField);
        addComponent(gui_Label_1);
        addComponent(gui_passwordTextField);
        addComponent(gui_buttonLogin);
        gui_Label.setText("Usuario:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "6.4139943% auto auto 31.866825%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
                gui_usuarioTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_usuarioTextField.setName("usuarioTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_usuarioTextField.getParent().getLayout()).setInsets(gui_usuarioTextField, "1.5873013mm auto auto 24.613556%").setReferenceComponents(gui_usuarioTextField, "0 -1 -1 -1").setReferencePositions(gui_usuarioTextField, "1.0 0.0 0.0 0.0");
        gui_Label_1.setText("Contrase\u00F1a:");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "17.492712% 0.0mm auto auto").setReferenceComponents(gui_Label_1, "-1 0 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
                gui_passwordTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_passwordTextField.setName("passwordTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_passwordTextField.getParent().getLayout()).setInsets(gui_passwordTextField, "25.655977% auto auto 23.305588%").setReferenceComponents(gui_passwordTextField, "-1 -1 -1 -1").setReferencePositions(gui_passwordTextField, "0.0 0.0 0.0 0.0");
        gui_buttonLogin.setText("Log in");
                gui_buttonLogin.setInlineStylesTheme(resourceObjectInstance);
        gui_buttonLogin.setName("buttonLogin");
        ((com.codename1.ui.layouts.LayeredLayout)gui_buttonLogin.getParent().getLayout()).setInsets(gui_buttonLogin, "33.381924% auto auto 1.5872955mm").setReferenceComponents(gui_buttonLogin, "-1 -1 -1 0 ").setReferencePositions(gui_buttonLogin, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    //Get user and password from database for the given user if it exists
    public void login(Component c, String id){
        ConnectionRequest r = new ConnectionRequest(){
            //Used to store the data produced by the API
            Hashtable data;
            @Override
            protected void postResponse() {
                try{
                    //Store the data into local variables
                    usuario = data.get("usuario").toString();
                    password = data.get("password").toString();
                    //if the input data is correct, go to the film form
                    if(usuario.compareTo(gui_usuarioTextField.getText())==0 && password.compareTo(gui_passwordTextField.getText())==0){
                        Form screen = new FormPeliculas();
                        screen.show();
                    }else{
                        new Dialog().show("¡Uy!", "Datos incorrectos.", "OK", "Cancelar");
                    }
                //Handle exception when user given does not exist
                }catch(NullPointerException npe){
                    new Dialog().show("¡Uy!", "Datos incorrectos.", "OK", "Cancelar");
                }
            }

            //Read data from the API
            @Override
            protected void readResponse(InputStream input) throws IOException {
                JSONParser p = new JSONParser();
                data = p.parse(new InputStreamReader(input));
            }
            
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/usuario/find/"+id);
        r.setPost(false);
        r.addArgument("q", "@codename-one");
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method to check if the inputs are empty. In case they are, return false, otherwise, returns true
    private boolean validar(){
        if(gui_usuarioTextField.getText().compareTo("")==0 || gui_passwordTextField.getText().compareTo("")==0){
            new Dialog().show("¡Uy!", "Has dejado alguno de los campos vacío.", "OK", "Cancelar");
            return false;
        }
        return true;
    }
    
    private void showLogin(){
        Form login = new FormLogin();
        login.show();
    }
    
    private void showRegistro(){
        Form registro = new FormRegistro();
        registro.show();
    }
    
    //Listeners for the buttons that will trigger the service if the validation passes
    public void onbuttonLoginActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if(validar()){
            this.login(ev.getComponent(), gui_usuarioTextField.getText());
        }
    }
}
