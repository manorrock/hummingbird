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
package com.manorrock.hummingbird.azure.files;

import java.io.InputStream;
import com.manorrock.hummingbird.api.VirtualFile;
import java.io.IOException;
import java.util.List;

/**
 * The File VirtualFile implementation.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AzureFileVirtualFile implements VirtualFile {

    /**
     * Stores the path.
     */
    private final String path;

    /**
     * Stores the file system.
     */
    private final AzureFileVirtualFileSystem fileSystem;
    
    /**
     * Constructor.
     * 
     * @param fileSystem the file system.
     * @param path the path.
     */
    public AzureFileVirtualFile(AzureFileVirtualFileSystem fileSystem, String path) {
        this.fileSystem = fileSystem;
        this.path = path;
    }
    
    /**
     * As an input stream.
     * 
     * @return an input stream, or null if not found or when an I/O error occurred.
     */
    @Override
    public InputStream asInputStream() {
        try {
            return fileSystem.getInputStream(path);
        } catch(IOException ioe) {
            return null;
        }
    }

    @Override
    public VirtualFile getFile(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<VirtualFile> getFiles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
