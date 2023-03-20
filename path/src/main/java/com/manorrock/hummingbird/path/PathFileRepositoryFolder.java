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

import com.manorrock.hummingbird.api.FileRepositoryFolder;
import com.manorrock.hummingbird.api.FileRepositoryItem;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The Path FileRepositoryFolder implementation.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class PathFileRepositoryFolder implements FileRepositoryFolder {

    /**
     * Stores the path.
     */
    private final Path folder;

    /**
     * Stores the repository.
     */
    private final PathFileRepository repository;

    /**
     * Constructor.
     *
     * @param repository the repository.
     * @param folder the folder.
     */
    public PathFileRepositoryFolder(PathFileRepository repository, Path folder) {
        this.folder = folder;
        this.repository = repository;
    }

    @Override
    public FileRepositoryItem getItem(String name) {
        FileRepositoryItem result = null;
        if (Files.isDirectory(folder)) {
            Optional<Path> file = null;
            try {
                file = Files
                        .walk(folder, 1)
                        .filter(p -> p.endsWith(name))
                        .limit(1)
                        .findFirst();
            } catch (IOException ioe) {
                // swallow up on purpose.
            }
            if (file != null && file.isPresent()) {
                result = new PathFileRepositoryItem(repository, file.get());
            }
        }
        return result;
    }

    @Override
    public List<FileRepositoryItem> getItems() {
        ArrayList<FileRepositoryItem> result = new ArrayList<>();
        if (Files.isDirectory(folder)) {
            try {
                Files.walk(folder, 1)
                        .forEach(p -> {
                            if (!Files.isDirectory(p)) {
                                PathFileRepositoryItem item = new PathFileRepositoryItem(repository, p);
                                result.add(item);
                            }
                        });
            } catch(IOException ioe) {
                // swallow up on purpose.
            }
        }
        return result;
    }

    @Override
    public Stream<FileRepositoryItem> items() {
        return getItems().stream();
    }
}
