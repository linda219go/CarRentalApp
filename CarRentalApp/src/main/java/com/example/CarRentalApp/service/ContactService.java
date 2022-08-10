package com.example.CarRentalApp.service;

import com.example.CarRentalApp.entity.Contact;
import com.example.CarRentalApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    public Contact saveMessage(Contact contactInfo) {
        return contactRepository.saveAndFlush(contactInfo);
    }
}
