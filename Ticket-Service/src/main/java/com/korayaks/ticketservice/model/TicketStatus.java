package com.korayaks.ticketservice.model;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Acik"),
    IN_PROGRESS("Islemde"),
    RESOLVED("Cozuldu"),
    CLOSED("Kapandi");
    private String label;
    TicketStatus(String label){
        this.label = label;
    }
}
