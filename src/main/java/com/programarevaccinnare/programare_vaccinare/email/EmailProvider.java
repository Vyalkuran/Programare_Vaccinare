package com.programarevaccinnare.programare_vaccinare.email;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;

public interface EmailProvider {
    public void sendEmail(Beneficiar beneficiar, CentruVaccinare centruVaccinare, String subiect, String mesaj);
}
