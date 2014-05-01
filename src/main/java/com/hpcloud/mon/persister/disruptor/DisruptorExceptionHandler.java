/*
 * Copyright (c) 2014 Hewlett-Packard Development Company, L.P.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hpcloud.mon.persister.disruptor;

import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisruptorExceptionHandler implements ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DisruptorExceptionHandler.class);

    @Override
    public void handleEventException(Throwable ex, long sequence, Object event) {

        logger.error("Disruptor encountered an exception during normal operation", ex);
        throw new RuntimeException(ex);
    }

    @Override
    public void handleOnStartException(Throwable ex) {

        logger.error("Disruptor encountered an exception during startup", ex);
        throw new RuntimeException(ex);
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {

        logger.error("Disruptor encountered an exception during shutdown", ex);
        throw new RuntimeException(ex);
    }
}
