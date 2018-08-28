/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * LocalRegistrar
 * Copyright (C) 2011 Charles Hymes <http://www.hymerfania.com>
 */
package com.sk89q.worldedit.util.command.fluent;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chymes
 */
public class LocalRegistrarTest {

    public LocalRegistrarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of commandAliases method, of class LocalRegistrar.
     */
    @Test
    public void testCommandAliases() {
        System.out.println("commandAliases");
        Method commandMethod = CommandSample00.commandMethod00;
        List<String> expResult = CommandSample00.test00_ALIASES_LIST;
        List<String> result = LocalRegistrar.commandAliases(commandMethod);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWorldEditConstructor method, of class LocalRegistrar.
     */
    @Test
    public void testHasWorldEditConstructor() {
        System.out.println("hasWorldEditConstructor");
        Class<CommandSample00> clazz = CommandSample00.class;
        boolean expResult = true;
        boolean result = LocalRegistrar.hasWorldEditConstructor(clazz);
        assertEquals(expResult, result);
    }

    /**
     * Test of commandMethods method, of class LocalRegistrar.
     */
    @Test
    public void testCommandMethods() {
        System.out.println("commandMethods");
        Class<CommandSample00> someClass = CommandSample00.class;
        List<Method> expResult = CommandSample00.COMMAND_METHODS;
        List<Method> result = LocalRegistrar.commandMethods(someClass);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of registerJaredCommands method, of class LocalRegistrar.
//     */
//    @Test
//    public void testRegisterJaredCommands() {
//        System.out.println("registerJaredCommands");
//        PlatformManager platformManager = null;
//        DispatcherNode dispatcherNode = null;
//        WorldEdit worldEdit = null;
//        DispatcherNode expResult = null;
//        DispatcherNode result = LocalRegistrar.registerJaredCommands(platformManager, dispatcherNode, worldEdit);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


}