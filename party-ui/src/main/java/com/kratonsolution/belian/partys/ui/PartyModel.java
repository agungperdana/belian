package com.kratonsolution.belian.partys.ui;

import java.util.List;

import org.zkoss.zul.ListModelList;

import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class PartyModel extends ListModelList<PartyData>
{
	private static final long serialVersionUID = -2389992394041942656L;

	private PartyModel(List<PartyData> list) {
		super(list, true);
	}
	
	public static PartyModel build(int page) {
		return new PartyModel(Springs.get(PartyService.class).
				getAllPartys(page-1, UIHelper.getSetting().getMaxRow()));
	}
}
