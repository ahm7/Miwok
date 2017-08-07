package com.example.android.miwok;
/**
 * Created by king on 7/30/2017.
 */

class Word {

    private  String miwoktranslation;
    private  String englishtranslation;
    private  int  image_id;
private  int audio_id;



    public  Word(String Miwoktranslation,String Englishtranslation ,int id,int id_2){
        miwoktranslation=Miwoktranslation;

        englishtranslation=Englishtranslation;
        image_id = id;
        audio_id = id_2;
    }
    public  String getMiwoktranslation(){
        return  miwoktranslation;
    }
    public  int getImage_id(){
        return  image_id;
    }

    public  String getEnglishtranslation(){
        return  englishtranslation;
    }
    public  int getAudio_id(){
        return  audio_id;
    }




}
