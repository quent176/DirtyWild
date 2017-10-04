package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {

    private String depare;
    private String oùilva;
    private String quan;

    public String getDepare() {
        return depare;
    }

    public String getOùilva() {
        return oùilva;
    }

    public SearchRequestModel(String depare, String oùilva, String quan) {
        this.depare = depare;
        this.oùilva = oùilva;
        this.quan = quan;
    }

        protected SearchRequestModel(Parcel in) {
            depare = in.readString();
            oùilva = in.readString();
            quan = in.readString();
        }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depare);
        dest.writeString(oùilva);
        dest.writeString(quan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
                @Override
                public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    public String getQuan() {
        return quan;
    }
}
