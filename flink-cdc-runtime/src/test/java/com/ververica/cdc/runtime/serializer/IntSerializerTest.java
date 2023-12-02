/*
 * Copyright 2023 Ververica Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.cdc.runtime.serializer;

import org.apache.flink.api.common.typeutils.TypeSerializer;

import java.util.Random;

/** A test for the {@link IntSerializer}. */
class IntSerializerTest extends SerializerTestBase<Integer> {

    @Override
    protected TypeSerializer<Integer> createSerializer() {
        return IntSerializer.INSTANCE;
    }

    @Override
    protected int getLength() {
        return 4;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }

    @Override
    protected Integer[] getTestData() {
        Random rnd = new Random(874597969123412341L);
        int rndInt = rnd.nextInt();

        return new Integer[] {0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE, rndInt, -rndInt};
    }
}