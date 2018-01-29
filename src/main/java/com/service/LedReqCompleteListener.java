package com.service;

public interface LedReqCompleteListener {
    void onBufferProgress(int i);

    void onSynthesizeCompleted(String s, String speechError);
}