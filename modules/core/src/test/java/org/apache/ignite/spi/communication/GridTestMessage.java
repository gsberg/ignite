/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.spi.communication;

import org.apache.ignite.internal.util.typedef.*;
import org.apache.ignite.plugin.extensions.communication.*;

import java.nio.*;
import java.util.*;

/**
 * Test message for communication SPI tests.
 */
public class GridTestMessage extends MessageAdapter {
    /** */
    public static final byte DIRECT_TYPE = (byte)200;

    /** */
    private UUID srcNodeId;

    /** */
    private long msgId;

    /** */
    private long resId;

    /** Network payload */
    private byte[] payload;

    /** */
    public GridTestMessage() {
        // No-op.
    }

    /**
     * @param srcNodeId Node that originated message.
     * @param msgId Message sequence id.
     * @param resId Response id.
     */
    public GridTestMessage(UUID srcNodeId, long msgId, long resId) {
        this.srcNodeId = srcNodeId;
        this.msgId = msgId;
        this.resId = resId;
    }

    /**
     * @return Id of message originator.
     */
    public UUID getSourceNodeId() {
        return srcNodeId;
    }

    /**
     * @return Message sequence id.
     */
    public long getMsgId() {
        return msgId;
    }

    /**
     * @return Response id.
     */
    public long getResponseId() {
        return resId;
    }

    /**
     * @param payload Payload to be set.
     */
    public void payload(byte[] payload) {
        this.payload = payload;
    }

    /**
     * @return Network payload.
     */
    public byte[] payload() {
        return payload;
    }

    /** {@inheritDoc} */
    @SuppressWarnings({"CloneDoesntCallSuperClone", "CloneCallsConstructors"})
    @Override public MessageAdapter clone() {
        GridTestMessage msg = new GridTestMessage();

        clone0(msg);

        return msg;
    }

    /** {@inheritDoc} */
    @Override protected void clone0(MessageAdapter _msg) {
        GridTestMessage _clone = (GridTestMessage)_msg;

        _clone.srcNodeId = srcNodeId;
        _clone.msgId = msgId;
        _clone.resId = resId;
        _clone.payload = payload;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("fallthrough")
    @Override public boolean writeTo(ByteBuffer buf, MessageWriteState state) {
//        writer.setBuffer(buf);
//
//        if (!typeWritten) {
//            if (!writer.writeByte(null, directType()))
//                return false;
//
//            typeWritten = true;
//        }
//
//        switch (state) {
//            case 0:
//                if (!writer.writeUuid(null, srcNodeId))
//                    return false;
//
//                state++;
//
//            case 1:
//                if (!writer.writeLong(null, msgId))
//                    return false;
//
//                state++;
//
//            case 2:
//                if (!writer.writeLong(null, resId))
//                    return false;
//
//                state++;
//
//            case 3:
//                if (!writer.writeByteArray(null, payload))
//                    return false;
//
//                state++;
//        }

        return true;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("fallthrough")
    @Override public boolean readFrom(ByteBuffer buf) {
//        reader.setBuffer(buf);
//
//        switch (state) {
//            case 0:
//                srcNodeId = reader.readUuid(null);
//
//                if (!reader.isLastRead())
//                    return false;
//
//                state++;
//
//            case 1:
//                msgId = reader.readLong(null);
//
//                if (!reader.isLastRead())
//                    return false;
//
//                state++;
//
//            case 2:
//                resId = reader.readLong(null);
//
//                if (!reader.isLastRead())
//                    return false;
//
//                state++;
//
//            case 3:
//                payload = reader.readByteArray(null);
//
//                if (!reader.isLastRead())
//                    return false;
//
//                state++;
//        }

        return true;
    }

    /** {@inheritDoc} */
    @Override public byte directType() {
        return DIRECT_TYPE;
    }

    /** {@inheritDoc} */
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof GridTestMessage))
            return false;

        GridTestMessage m = (GridTestMessage)o;

        return F.eq(srcNodeId, m.srcNodeId) && F.eq(msgId, m.msgId) && F.eq(resId, m.resId);
    }

    /** {@inheritDoc} */
    @Override public int hashCode() {
        int res = srcNodeId.hashCode();

        res = 31 * res + (int)(msgId ^ (msgId >>> 32));
        res = 31 * res + (int)(resId ^ (resId >>> 32));

        return res;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append(getClass().getSimpleName());
        buf.append(" [srcNodeId=").append(srcNodeId);
        buf.append(", msgId=").append(msgId);
        buf.append(", resId=").append(resId);
        buf.append(']');

        return buf.toString();
    }
}
