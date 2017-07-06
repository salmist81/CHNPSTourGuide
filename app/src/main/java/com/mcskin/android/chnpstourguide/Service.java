package com.mcskin.android.chnpstourguide;

/**
 * Created by McSkin on 17/06/2017.
 *
 * {@Link Service} represents a title head with a particular service  that the user want to know.
 * It contains a note description briefly describing the title head for that service.
 */

public class Service {
    //This is the title head for the service
    private String mTitleHead;

    //This is a note  for the service
    private String mNote;


    //This is a note description for the service
    private String mNoteDescription;

    //Image Resource ID for a service */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Service object.
     *
     * @param titleHead is the title head for a service
     *
     *@param note is a note for a service
     *
     * @param noteDescription is a note description for a service
     *
     * @param imageResourceId is the drawable resource ID associated with the service
     */
    public Service(String titleHead, String note, String noteDescription, int imageResourceId){

        mTitleHead = titleHead;
        mNote = note;
        mNoteDescription = noteDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the title head for the service
     */
    public String getTitleHead() {
        return mTitleHead;
    }

    /**
     * Get the note description for the service
     */
    public String getNote() {
        return mNote;
    }


    /**
     * Get the note description for the service
     */
    public String getNoteDescription() {
        return mNoteDescription;
    }

    /**
     * Returns the image resource ID of the service
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this service
     * @return
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
