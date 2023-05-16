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
package com.manorrock.hummingbird.path;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import com.manorrock.hummingbird.api.VirtualFile;
import java.util.List;

/**
 * The Path VirtualFile implementation.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class PathFile implements VirtualFile {

    /**
     * Stores the file.
     */
    private Path file;

    /**
     * Stores the file system.
     */
    private PathFileSystem fileSystem;
    
    /**
     * Constructor.
     * 
     * @param fileSystem the file system.
     * @param file the file.
     */
    public PathFile(PathFileSystem fileSystem, Path file) {
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
        PipedOutputStream pipedOutput = new PipedOutputStream();
        try {
            result = new PipedInputStream(pipedOutput);
            Files.copy(file, pipedOutput);
        } catch (IOException ioe) {
            // swallowed up on purpose.
        }
        return result;
    }

    @Override
    public VirtualFile getFile(String path) {
        Path newPath = Path.of(file.toString(), path).normalize();
        return new PathFile(fileSystem, newPath);
    }

    @Override
    public List<VirtualFile> getFiles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
