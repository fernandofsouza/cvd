/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.fernando.cvd.security;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.event.Observes;

/**
 * <p>A simple CDI observer for the {@link org.picketlink.event.SecurityConfigurationEvent}.</p>
 *
 * <p>The event is fired during application startup and allows you to provide any configuration to PicketLink
 * before it is initialized.</p>
 *
 * <p>All the configuration related with Http Security is provided from this bean.</p>
 *
 * @author Pedro Igor
 */
public class HttpSecurityConfiguration {

    public void onInit(@Observes SecurityConfigurationEvent event) {
        SecurityConfigurationBuilder builder = event.getBuilder();

        builder
            .http()
            .forPath("/javax.faces.resource/*").unprotected()
            	.forPath("/index.xhtml")
            	.forPath("/public/produtos-venda.xhtml")
                .allPaths()
                    .authenticateWith()
                        .form()
                            .authenticationUri("/public/login.xhtml")
                            .loginPage("/public/login.xhtml")
                            .errorPage("/403.xhtml")
                            .restoreOriginalRequest()
                .forPath("/auth/protected/*")
                	.authenticateWith()
                		.form()
                			.authenticationUri("/public/login.xhtml")
                			.loginPage("/public/login.xhtml")
                			.errorPage("/403.xhtml")
                			.restoreOriginalRequest()
                	.authorizeWith()
                		.role("superuser")
                .forPath("/logout")
                    .logout()
                    .redirectTo("/index.xhtml");
    }

}
