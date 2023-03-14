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
package com.manorrock.hummingbird.calico;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * The Path implementation for Manorrock Calico.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class CalicoPath implements Path {

    /**
     * Stores the provider.
     */
    private CalicoFileSystemProvider provider;
    
    /**
     * Stores the URI.
     */
    private URI uri;
    
    /**
     * Constructor.
     * 
     * @param provider the provider.
     * @param uri the URI.
     */
    public CalicoPath(CalicoFileSystemProvider provider, URI uri) {
        this.provider = provider;
        this.uri = uri;
    }

    @Override
    public FileSystem getFileSystem() {
        return new CalicoFileSystem(provider);
    }

    @Override
    public URI toUri() {
        return uri;
    }

    @Override
    public boolean isAbsolute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path getRoot() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path getFileName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path getParent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNameCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path getName(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean startsWith(Path other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean endsWith(Path other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path resolve(Path other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path relativize(Path other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path toAbsolutePath() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(Path other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
