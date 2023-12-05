package com.savvycom.userservice.service;

public interface ISendMailService {
    void sendMail(String to, String subject, String text);
}
