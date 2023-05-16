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
package com.manorrock.hummingbird.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.manorrock.hummingbird.api.VirtualFile;
import java.util.List;

/**
 * The File VirtualFile implementation.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class FileVirtualFile implements VirtualFile {

    /**
     * Stores the file.
     */
    private File file;

    /**
     * Stores the file system.
     */
    private FileVirtualFileSystem fileSystem;
    
    /**
     * Constructor.
     * 
     * @param fileSystem the file systemy.
     * @param file the file.
     */
    public FileVirtualFile(FileVirtualFileSystem fileSystem, File file) {
        this.file = file;
        this.fileSystem = fileSystem;
    }
    
    /**
     * As an input stream.
     * 
     * @return an input stream, or null if not found.
     */
    @Override
    public InputStream asInputStream() {
        InputStream result = null;
        try {
            result = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            // swallowed up on purpose.
        }
        return result;
    }

    @Override
    public VirtualFile getFile(String path) {
        File newFile = new File(file, path);
        return new FileVirtualFile(fileSystem, newFile);
    }

    @Override
    public List<VirtualFile> getFiles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
