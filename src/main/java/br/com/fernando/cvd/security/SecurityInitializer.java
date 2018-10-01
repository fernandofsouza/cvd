/*
 ** JBoss, Home of Professional Open Source
 ** Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 ** contributors by the @authors tag. See the copyright.txt in the
 ** distribution for a full listing of individual contributors.
 **
 ** Licensed under the Apache License, Version 2.0 (the "License");
 ** you may not use this file except in compliance with the License.
 ** You may obtain a copy of the License at
 ** http://www.apache.org/licenses/LICENSE-2.0
 ** Unless required by applicable law or agreed to in writing, software
 ** distributed under the License is distributed on an "AS IS" BASIS,
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ** See the License for the specific language governing permissions and
 ** limitations under the License.
 **/
package br.com.fernando.cvd.security;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

/**
 ** This startup bean creates a default user account when the application is started. Since we are not
 ** providing an IDM configuration in this example, PicketLink will default to using a file-based identity
 ** store to persist user and other identity state.
 **
 **
 ** @author Shane Bryzak
 **/
@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {
        IdentityManager identityManager = this.partitionManager.createIdentityManager();
        RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();
        //Criação de usuários
        User user = new User("fernando@souza");

        user.setEmail("fernando@souza.com");
        user.setFirstName("fernando");
        user.setLastName("souza");
        
        
        identityManager.add(user);
        identityManager.updateCredential(user, new Password("fernando"));
        
        user = new User("admin@faces.com");
        user.setEmail("admin@faces.com");
        user.setFirstName("admin");
        user.setLastName("faces");
        
        identityManager.add(user);
        identityManager.updateCredential(user, new Password("admin"));
        
        user = new User("user@faces.com");
        user.setEmail("user@faces.com");
        user.setFirstName("user");
        user.setLastName("facesUser");
        
        identityManager.add(user);
        identityManager.updateCredential(user, new Password("user"));
        //Criação de roles
        User admin = BasicModel.getUser(identityManager, "admin@faces.com");
        Role superuser = new Role("superuser");
        identityManager.add(superuser);
        BasicModel.grantRole(relationshipManager, admin, superuser);
        
        
    }
}
