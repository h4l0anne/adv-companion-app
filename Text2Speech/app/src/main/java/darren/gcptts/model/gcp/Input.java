package darren.gcptts.model.gcp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Author: Changemyminds.
 * Date: 2018/6/23.
 * Description:
 * Reference:
 */
public class Input implements VoiceParameter {
    private String mText;
    private boolean mIsEnableSSML;

    Input(String text) {
        mText = text;
        mIsEnableSSML = false;
    }

    public Input(String text, boolean isSSML) {
        mText = text;
        mIsEnableSSML = isSSML;
    }

    @Override
    public String getJSONHeader() {
        return "input";
    }

    public JSONObject toJSONObject(){
        JSONObject jsonText= new JSONObject();
        try {
            jsonText.put((mIsEnableSSML) ? "ssml" : "text", mText);
            return jsonText;
        } catch (JSONException e) {
//            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Deprecated
    @Override
    public String toString() {
        String text = "'" + this.getClass().getSimpleName().toLowerCase() + "':{";
        text += (mIsEnableSSML) ? "'ssml':'" + mText + "'}" : "'text':'" + mText + "'}";
        return text;
    }
}
