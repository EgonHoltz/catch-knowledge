package pt.holtz.catchknowledge.catchservice.service.param;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;

public class ActivityParametersImpl implements IActivityParameters{

	@Override
	public JSONConfigParameters getActivityParameters() {
		return new JSONConfigParameters();
	}

}
