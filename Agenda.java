package src;


import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


/**
 *
 * @author Morvan
 */
public class Agenda extends MIDlet implements CommandListener {
    private Display d;
    private Command pesq,add,exc,grav,ok,voltar,sair;
    private Form f1,f2;
    private List l;
    private TextField nome,tel,email,pesqnome;
    private TextBox box;
    private Contato cont;
    
    public Agenda(){
        d = Display.getDisplay(this);
        pesq = new Command("Pesquisar",Command.SCREEN,1);
        add = new Command("Adicionar",Command.SCREEN,1);
        exc = new Command("Excluir", Command.SCREEN,1);
        voltar = new Command("Voltar",Command.SCREEN,2);
        sair = new Command("Sair",Command.EXIT,2);
        box = new TextBox("Contato","",50,TextField.ANY);
        l = new List("Agenda",List.IMPLICIT);
        
        //Form 1 - Adicionar Contato
        f1 = new Form("Adicionar Contato");
        nome = new TextField("Nome:","",10,TextField.ANY);
        tel = new TextField("Tel.:","",10,TextField.PHONENUMBER);
        email = new TextField("Email:","",15,TextField.ANY);        
        grav = new Command("Gravar",Command.OK,1);
        
        //Form 2 - Pesquisar
        f2 = new Form("Busca");
        pesqnome = new TextField("Nome:","",10,TextField.ANY);        
        ok = new Command ("OK",Command.SCREEN,1);
        
        //Tela Principal
        l.addCommand(add);
        l.addCommand(pesq);
        l.addCommand(sair);
        l.setCommandListener(this);
        
        
        //Tela de Cadastro
        f1.append(nome);
        f1.append(tel);
        f1.append(email);
        f1.addCommand(grav);
        f1.addCommand(voltar);
        f1.setCommandListener(this);
        
        //Tela de Busca
        f2.append(pesqnome);
        f2.addCommand(ok);
        f2.addCommand(voltar);
        f2.setCommandListener(this);
        
        //Tela Resultado da Busca
        box.addCommand(voltar);
        box.addCommand(exc);
        box.setCommandListener(this);
    }

    protected void destroyApp(boolean bln) {
        
    }

    protected void pauseApp() {
        
    }

    protected void startApp() {
        d.setCurrent(l);
    }

    public void commandAction(Command c, Displayable f) {
        //Sair da Agenda
        if( c == sair){
                destroyApp(false);           
                notifyDestroyed();
        }
        
        //Vai para a tela de Adicionar Contato
        if(c == add){
            d.setCurrent(f1);
        }
        
        //Grava e volta para a tela inicial
        if(c == grav){
            d.setCurrent(l);
        }
        
        //Apenas volta para a tela anterior
        if(c == voltar){
            d.setCurrent(l);
        }
        
        //Vai para a tela de pesquisa
        if(c == pesq){
            d.setCurrent(f2);
        }
        if(c == ok){
            d.setCurrent(box);
        }
        
        //Exclui Contato
        if(c == exc){
            
        }
    }
    
    
    
}
