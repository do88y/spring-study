package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName;
    private String storeFileName; //고객이 업로드한 파일명으로 서버에 파일 저장하면 안 됨.
                                  //같은 경로에 같은 파일이름이면 덮어쓰기가 되기 때문에 UUID 같은 별도의 파일명으로 안 겹치게 저장해야 함

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
