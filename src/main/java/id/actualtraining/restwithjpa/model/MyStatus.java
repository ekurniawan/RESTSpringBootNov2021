package id.actualtraining.restwithjpa.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MyStatus {
    private String kode;
    private String deskripsi;
}
