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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.matches;

/**
 * A Maven repository FileSystem backed Path.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MavenRepositoryFileSystemPath implements Path {
    
    /**
     * Stores the group id.
     */
    private String groupId;
    
    /**
     * Stores the artifact id.
     */
    private String artifactId;
    
    /**
     * Stores the version.
     */
    private String version;

    /**
     * Stores the file system.
     */
    private FileSystem fileSystem;
    
    /**
     * Constructor.
     * 
     * @param fileSystem the file system.
     * @param uri the URI.
     */
    public MavenRepositoryFileSystemPath(FileSystem fileSystem, URI uri) {
        this.fileSystem = fileSystem;
        parse(uri);
    }

    @Override
    public FileSystem getFileSystem() {
        return fileSystem;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    /**
     * Parse out the groupId, artifactId and version.
     * 
     * @param uri the URI to parse.
     */
    private void parse(URI uri) {
        System.out.println("Path: " + uri.getPath());
        Pattern pattern = Pattern.compile("/(.+)/(.+)/(.+)(/(.+))?");
        Matcher matcher = pattern.matcher(uri.getPath());
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.groupCount());
    }

    @Override
    public Path toAbsolutePath() {
       File file = new File(System.getProperty("user.home") + "/.m2/repository" + groupId);
       return file.toPath();
    }

    // ------------------------------------------------------------------------
    
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
    public URI toUri() {
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
