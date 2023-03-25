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
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.manorrock.hummingbird.api.VirtualFile;
import com.manorrock.hummingbird.api.VirtualFileFolder;

/**
 * The File VirtualFileFolder implementation.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class FileVirtualFileFolder implements VirtualFileFolder {

    /**
     * Stores the folder.
     */
    private final File directory;

    /**
     * Stores the file system.
     */
    private final FileVirtualFileSystem fileSystem;

    /**
     * Constructor.
     *
     * @param fileSystem the file system.
     * @param directory the directory.
     */
    public FileVirtualFileFolder(FileVirtualFileSystem fileSystem, File directory) {
        this.directory = directory;
        this.fileSystem = fileSystem;
    }

    @Override
    public VirtualFile getFile(String name) {
        VirtualFile result = null;
        File[] files = directory.listFiles(
                new FilenameFilter() {
            @Override
            public boolean accept(File acceptDirectory, String acceptName) {
                boolean result = false;
                if (acceptName.equals(name)) {
                    result = true;
                }
                return result;
            }
        });
        if (files.length > 0) {
            result = new FileVirtualFile(fileSystem, files[0]);
        }
        return result;
    }

    @Override
    public List<VirtualFile> getFiles() {
        ArrayList<VirtualFile> result = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    FileVirtualFile item = new FileVirtualFile(fileSystem, file);
                    result.add(item);
                }
            }
        }
        return result;
    }

    @Override
    public Stream<VirtualFile> files() {
        return getFiles().stream();
    }
}
