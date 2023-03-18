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

import com.manorrock.hummingbird.api.FileRepositoryFolder;
import com.manorrock.hummingbird.api.FileRepositoryItem;
import java.util.List;
import java.util.stream.Stream;

/**
 * The Manorrock Calico FileRepositoryFolder implementation.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class CalicoRepositoryDirectory implements FileRepositoryFolder {

    /**
     * Stores the repository.
     */
    private final CalicoRepository repository;
    
    /**
     * Stores the path.
     */
    private final String path;

    /**
     * Constructor.
     *
     * @param repository the repository.
     */
    public CalicoRepositoryDirectory(CalicoRepository repository) {
        this.path = "";
        this.repository = repository;
    }

    @Override
    public FileRepositoryItem getItem(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<FileRepositoryItem> getItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Stream<FileRepositoryItem> items() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
