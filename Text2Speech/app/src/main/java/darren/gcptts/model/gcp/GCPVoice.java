package darren.gcptts.model.gcp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Author: Changemyminds.
 * Date: 2018/6/23.
 * Description:
 * Reference:
 */
public class GCPVoice implements VoiceParameter {
    private String mLanguageCode;
    private String mName;
    private ESSMLlVoiceGender mESSMLlGender;
    private int mNaturalSampleRateHertz;

    public GCPVoice(String languageCode, String name) {
        mLanguageCode = languageCode;
        mName = name;
        mESSMLlGender = ESSMLlVoiceGender.NONE;
        mNaturalSampleRateHertz = 0;
    }

    public GCPVoice(String languageCode, String name, ESSMLlVoiceGender eSSMLlGender) {
        mLanguageCode = languageCode;
        mName = name;
        mESSMLlGender = eSSMLlGender;
        mNaturalSampleRateHertz = 0;
    }

    public GCPVoice(String languageCode, String name, ESSMLlVoiceGender eSSMLlGender,
                    int naturalSampleRateHertz) {
        mLanguageCode = languageCode;
        mName = name;
        mESSMLlGender = eSSMLlGender;
        mNaturalSampleRateHertz = naturalSampleRateHertz;
    }

    @Override
    public String getJSONHeader() {
        return "voice";
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("languageCode", mLanguageCode);
            jsonObject.put("name", mName);
            if (mESSMLlGender != ESSMLlVoiceGender.NONE){
                jsonObject.put("name", mESSMLlGender.toString());
            }
            if ((mNaturalSampleRateHertz != 0)) {
                jsonObject.put("naturalSampleRateHertz", String.valueOf(mNaturalSampleRateHertz));
            }
            return jsonObject;
        } catch (JSONException e) {
//            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


    @Deprecated
    @Override
    public String toString() {
        String text = "'voice':{";
        text += "'languageCode':'" + mLanguageCode + "',";
        text += "'name':'" + mName + "'";
        text += (mESSMLlGender == ESSMLlVoiceGender.NONE) ? "" :
                ",'ssmlGender':'" + mESSMLlGender.toString() + "'";
        text += (mNaturalSampleRateHertz == 0) ? "" :
                ",'naturalSampleRateHertz':'" + String.valueOf(mNaturalSampleRateHertz) + "'";
        text += "}";
        return text;
    }

    public String getLanguageCode() {
        return mLanguageCode;
    }

    public String getName() {
        return mName;
    }

    public ESSMLlVoiceGender getESSMLlGender() {
        return mESSMLlGender;
    }

    public int getNaturalSampleRateHertz() {
        return mNaturalSampleRateHertz;
    }
}
