package org.javalearners.messenger.applications;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.javalearners.messenger.exception.DataNotFoundExceptionMapper;
import org.javalearners.messenger.exception.GenericExceptionMapper;
import org.javalearners.messenger.resources.CommentResource;
import org.javalearners.messenger.resources.InjectDemoResource;
import org.javalearners.messenger.resources.MessageResource;
import org.javalearners.messenger.resources.ProfileResource;

@ApplicationPath("webapi")
public class MessengerApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(MessageResource.class);
        classes.add(ProfileResource.class);
        classes.add(CommentResource.class);
        classes.add(InjectDemoResource.class);
        
        classes.add(DataNotFoundExceptionMapper.class);
        classes.add(GenericExceptionMapper.class);
        return classes;
    }

}
