package com.dream.service;

/**
 *
 */
public interface RedisTemplateService {
    /**
     * 执行多个指令
     */
    void execMultiCommand();
    /**
     * 执行Redis事务
     */
    void execTransaction();
    /**
     * 执行Redis流水线
     */
    void execPipeLine();
}
