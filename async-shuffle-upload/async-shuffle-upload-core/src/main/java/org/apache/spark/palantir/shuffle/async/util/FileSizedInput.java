/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.palantir.shuffle.async.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.spark.io.NioBufferedFileInputStream;

public final class FileSizedInput implements SizedInput {

  private final File file;
  private final int bufferSize;

  public FileSizedInput(File file, int bufferSize) {
    this.file = file;
    this.bufferSize = bufferSize;
  }

  @Override
  public long getStreamSizeInBytes() {
    return file.length();
  }

  @Override
  public InputStream openStream() throws IOException {
    return new NioBufferedFileInputStream(file, bufferSize);
  }
}
