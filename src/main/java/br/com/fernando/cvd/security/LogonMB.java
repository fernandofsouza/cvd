package br.com.fernando.cvd.security;

import static br.com.fernando.cvd.util.FacesUtil.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.github.adminfaces.template.session.AdminSession;



@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {

    
	private static final long serialVersionUID = 1L;
	
	
	private String email;
    private String password;
    private boolean remember;

    private Logger log = Logger.getLogger(LogonMB.class.getName());


    public void login() throws IOException {
        UsernamePasswordToken token = new UsernamePasswordToken(email,
                password);

        // "Remember Me" built-in:
        token.setRememberMe(remember);

        Subject currentUser = SecurityUtils.getSubject();

        log.log(Level.INFO, "Submitting login with username of {0} and password of {1}", new Object[]{email, password});
        try {
            currentUser.login(token);
            addDetailMessage("Logged in successfully as <b>" + email + "</b>");
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            Faces.redirect("index.xhtml");
       /* you can handle specific exceptions*/
        } catch (UnknownAccountException uae) {
            //username wasn't in the system, show them an error message?
            throw uae;
        } catch (IncorrectCredentialsException ice) {
            //password didn't match, try again?
            throw ice;
        } catch (LockedAccountException lae) {
            //account for that username is locked - can't login.  Show them a message?
            throw lae;
        } catch (Exception e) {
            // Could catch a subclass of AuthenticationException if you like
            log.log(Level.SEVERE, e.getMessage(), e);
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            Messages.addFatal(null,"Login Failed:" + e.getMessage());
        }
    }
        
    public void logout(){
    	Subject currentUser = SecurityUtils.getSubject();
    	log.info( "User [" + currentUser.getPrincipal() + "] logged out successfully." );
    	currentUser.logout();
    }
    
    @Override
    public boolean isLoggedIn() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return SecurityUtils.getSubject().getPrincipal().toString();
    }

}