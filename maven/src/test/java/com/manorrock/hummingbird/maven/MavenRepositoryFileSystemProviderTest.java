/*
 * Copyright (c) 2002-2023 Manorrock.com. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, 
 *      this list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *   3. Neither the name of the copyright holder nor the names of its 
 *      contributors may be used to endorse or promote products derived from this
 *      software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.manorrock.hummingbird.maven;

import java.net.URI;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MavenRepositoryFileSystemProvider.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MavenRepositoryFileSystemProviderTest {
    
    /**
     * Test createDirectory method.
     */
    @Test
    void testCreateDirectory() {
        MavenRepositoryFileSystemProvider provider = new MavenRepositoryFileSystemProvider();
        assertThrows(UnsupportedOperationException.class, () -> {provider.createDirectory(null, null);});
    }
    
    /**
     * Test getFilesystem method.
     * 
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testGetFilesystem() throws Exception {
        MavenRepositoryFileSystemProvider provider = new MavenRepositoryFileSystemProvider();
        assertNotNull(provider.getFileSystem(new URI("maven://local")));
        assertTrue(provider.getFileSystem(new URI("maven://local")) instanceof MavenRepositoryFileSystem);
    }
    
    /**
     * Test getPath method.
     * 
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testGetPath() throws Exception {
//        MavenRepositoryFileSystemProvider provider = new MavenRepositoryFileSystemProvider();
//        Path path = provider.getPath(new URI("maven://local/org.junit.jupiter/junit-jupiter-api/5.9.1/jar"));
//        assertNotNull(path);
//        assertTrue(path.isAbsolute());
//        InputStream inputStream = Files.newInputStream(path);
//        assertNotNull(inputStream);
    }
    
    /**
     * Test getScheme method.
     */
    @Test
    public void testGetScheme() {
        MavenRepositoryFileSystemProvider provider = new MavenRepositoryFileSystemProvider();
        assertEquals("maven", provider.getScheme());
    }
    
    /**
     * Test newFileSystem method.
     * 
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testNewFilesystem() throws Exception {
        MavenRepositoryFileSystemProvider provider = new MavenRepositoryFileSystemProvider();
        assertNotNull(provider.newFileSystem(new URI("maven://local"), new HashMap<>()));
    }
}
