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

import com.azure.storage.file.share.ShareClient;
import com.azure.storage.file.share.ShareClientBuilder;
import com.manorrock.hummingbird.api.VirtualFile;
import com.manorrock.hummingbird.api.VirtualFileSystem;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Azure Files VirtualFileSystem implementation.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AzureFileVirtualFileSystem implements VirtualFileSystem {

    /**
     * Stores the client.
     */
    private final ShareClient client;
    
    /**
     * Constructor.
     * 
     * @param endpoint the endpoint.
     * @param shareName the share name.
     * @param sasToken the SAS token.
     */
    public AzureFileVirtualFileSystem(String endpoint, String shareName,
            String sasToken) {
        
        this.client = new ShareClientBuilder()
                .endpoint(endpoint)
                .shareName(shareName)
                .sasToken(sasToken)
                .buildClient();
    }
        
    @Override
    public VirtualFile getRootFolder() {
        return new AzureFileVirtualFile(this, "");
    }

    /**
     * Get the files for the given path.
     * 
     * @param path the path.
     * @return the files (if any).
     */
    public List<VirtualFile> getFiles(String path) {
        return null;
        
//        return client.getDirectoryClient(folder)
//                // get all files/directories
//                .listFilesAndDirectories()                                      
//                .stream()
//                // filter out directories
//                .filter(i -> !i.isDirectory())
//                // convert ShareFileItem to AzureFileVirtualFile
//                .map(i -> new AzureFileVirtualFile(this, folder, i.getName())) 
//                // collect it all in a list
//                .collect(Collectors.toList());
    }
    
    /**
     * Get an InputStream for the given file.
     * 
     * @param path the path.
     * @return the input stream.
     * @throws IOException when an I/O error occurs.
     */
    public InputStream getInputStream(String path) throws IOException {
        PipedOutputStream outputStream = new PipedOutputStream();
        client.getFileClient(path).download(outputStream);
        return new PipedInputStream(outputStream);
    }
}
