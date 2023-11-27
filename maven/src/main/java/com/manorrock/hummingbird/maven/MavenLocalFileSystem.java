/*
 *  Copyright (c) 2002-2023, Manorrock.com. All Rights Reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *      1. Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *
 *      2. Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 *  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 *  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 */
package com.manorrock.hummingbird.maven;

import com.manorrock.hummingbird.api.VirtualFile;
import com.manorrock.hummingbird.api.VirtualFileSystem;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;

/**
 * The Maven local VirtualFileSystem implementation.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MavenLocalFileSystem implements VirtualFileSystem {

    /**
     * Stores the root directory
     */
    private final File rootDirectory;
    
    /**
     * Constructor.
     * 
     * @param rootDirectory the root directory.
     */
    public MavenLocalFileSystem(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }
    
    /**
     * Constructor.
     * 
     * @param rootUri the root directory as specified by the given URI.
     */
    public MavenLocalFileSystem(URI rootUri) {
        this.rootDirectory = Path.of(rootUri).toFile();
    }
    
    @Override
    public VirtualFile getRootFolder() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
