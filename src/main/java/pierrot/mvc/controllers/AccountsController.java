package pierrot.mvc.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pierrot.mvc.repositories.AccountRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * A controller handling requests for showing and updating an Account.
 */
@Slf4j
@Controller
@RequestMapping("/accounts")
public class AccountsController {
	

	private AccountRepository accountRepo;

	@Autowired
	public AccountsController(AccountRepository AccountRepository) {
		this.accountRepo = AccountRepository;
	}

	/**
	 * Handles requests to list all accounts for currently logged in user.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Principal prinicpal, Model model) {
//		if (prinicpal == null)
//			throw new AccessDeniedException("Not authenitcated");
//
//		model.addAttribute("customer", AccountRepository.findCustomer(prinicpal.getName()));
//		assert(model.asMap().get("customer") != null);
		log.info("Customer = " + model.asMap().get("customer") );
		return "accounts/list";
	}

	/**
	 * Handles requests to shows detail about one account.
	 */
	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	public String show(@PathVariable String number, Model model) {
//		model.addAttribute(AccountRepository.findAccount(number));
		return "accounts/show";
	}

}