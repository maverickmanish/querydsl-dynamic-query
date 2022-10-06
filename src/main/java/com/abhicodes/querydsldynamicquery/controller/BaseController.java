package com.abhicodes.querydsldynamicquery.controller;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import com.abhicodes.querydsldynamicquery.vo.PageableResponse;

/**
 * The Class BaseController.
 */
@RestController
public class BaseController {
/*	@InitBinder plays the role to identify the methods which initialize the WebDataBinder. The @InitBinder method supports many arguments as by @RequestMapping methods.

	@InitBinder method does not support command or form arguments. Mostly used argument is WebDataBinder in @InitBinder method.

	WebDataBinder is a DataBinder that binds request parameter to JavaBean objects, works as a preprocessor for each request coming to the controller..
	 //Externalize this value
    @Value("${myApplication.autoGrowCollectionLimit:600}")
    private int autoGrowCollectionLimit;
    dataBinder.setAutoGrowCollectionLimit(autoGrowCollectionLimit);*/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("DoNotSeperate"));
	}

	/**
	 * Format page response.
	 *
	 * @param page the page
	 * @return the pageable response
	 */
	public PageableResponse formatPageResponse(Page<?> page) {
		return PageableResponse.builder().currentPage(page.getNumber() + 1).pageSize(page.getSize())
				.totalPages(page.getTotalPages()).totalElements(page.getTotalElements()).results(page.getContent())
				.build();
	}

}
