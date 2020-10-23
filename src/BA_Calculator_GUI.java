/**
 * program name: BA_GUI.java
 * Purpose: create GUI for a a student loans calculator
 * Coder: Bilal Al-Muhtadi
 * Date: Apr. 4, 2020
 */
import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;
import java.util.ArrayList;

public class BA_Calculator_GUI extends JFrame implements BA_LoanPayable
{

	// class scope
	ArrayList<Student> students = new ArrayList<Student>();
	JLabel titleLbl;
	JPanel topPanel, centerPanel, eastPanel, westPanel;
	JTextField idNum, firstNameTxt, middleNameTxt, surnameTxt, aptNumTxt, streetNumTxt, streetNameTxt, cityTxt, provinceTxt, postalcodeTxt, cslTxt, oslTxt,amortizationMonths;
	JButton sbmtBtn, repaymentForm, previousBtn, nextBtn, calculateBtn;
	private JComboBox cityBox, provinceBox, wholeNumPercent, fractionPercent;
	int index = 0;
	
	
	//arrays that will be used to populate JComboBoxes
	String[] fractions = {".00",".25", ".5", ".75"};
	
	String[] provinceArray = {"Alberta", "British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut"
			,"Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon Territory" };
	
	String[] cities_AB = {"Airdrie","Grande Prairie" ,"Red Deer" ,"Beaumont" ,"Hanna" ,"St. Albert" ,"Bonnyville" ,"Hinton" ,"Spruce Grove" ,"Brazeau" ,"Irricana" ,"Strathcona County"
											,"Breton" ,"Lacombe" ,"Strathmore" ,"Calgary" ,"Leduc" ,"Sylvan Lake" ,"Camrose" ,"Lethbridge" ,"Swan Hills" ,"Canmore" ,"McLennan" ,"Taber","Didzbury" 
											,"Medicine Hat" ,"Turner Valley" ,"Drayton Valley" ,"Olds" ,"Vermillion" ,"Edmonton" ,"Onoway" ,"Wood Buffalo" ,"Ft. Saskatchewan" ,"Provost"  
											 };
	
	
	String[] cities_BC = {"Burnaby" ,"Lumby" ,"City of Port Moody" ,"Cache Creek" ,"Maple Ridge" ,"Prince George" ,"Castlegar" ,"Merritt" ,"Prince Rupert" ,"Chemainus"
												,"Mission" ,"Richmond" ,"Chilliwack" ,"Nanaimo" ,"Saanich" ,"Clearwater" ,"Nelson" ,"Sooke" ,"Colwood" ,"New Westminster" ,"Sparwood" ,"Coquitlam" 
												,"North Cowichan" ,"Surrey" ,"Cranbrook" ,"North Vancouver" ,"Terrace" ,"Dawson Creek" ,"North Vancouver" ,"Tumbler" ,"Delta" ,"Osoyoos" ,"Vancouver" 
												,"Fernie" ,"Parksville" ,"Vancouver" ,"Invermere" ,"Peace River" ,"Vernon" ,"Kamloops" ,"Penticton" ,"Victoria" ,"Kaslo" ,"Port Alberni" ,"Whistler" ,"Langley" ,"Port Hardy" 
											 };
	
	
	String[] cities_MB = {"Birtle" ,"Flin Flon" ,"Swan River" ,"Brandon" ,"Snow Lake" ,"The Pas" ,"Cranberry Portage" ,"Steinbach" ,"Thompson" ,"Dauphin"
											 ,"Stonewall" ,"Winnipeg"
							         };
	
	
	String[] cities_NB = {"Cap-Pele" ,"Miramichi" ,"Saint John" ,"Fredericton" ,"Moncton" ,"Saint Stephen" ,"Grand Bay-Westfield" ,"Oromocto" ,"Shippagan"
			                 ,"Grand Falls" ,"Port Elgin" ,"Sussex" ,"Memramcook" ,"Sackville" ,"Tracadie-Sheila"
	                     };
	
	
	String[] cities_NL = {"Argentia" ,"Corner Brook" ,"Paradise" ,"Bishop's Falls" ,"Labrador City" ,"Portaux Basques" ,"Botwood" ,"Mount Pearl" ,"St. John's" ,"Brigus" };
	
	
	String[] cities_NT = {"Town of Hay River" ,"Town of Inuvik" ,"Yellowknife"};
	
	
	String[] cities_NS = {"Amherst" ,"Hants County" ,"Pictou" ,"Annapolis" ,"Inverness County" ,"Pictou County" ,"Argyle" ,"Kentville" ,"Queens" ,"Baddeck"
											 ,"County of Kings" ,"Richmond" ,"Bridgewater" ,"Lunenburg" ,"Shelburne" ,"Cape Breton" ,"Lunenburg County" ,"Stellarton" ,"Chester"
											 ,"Mahone Bay" ,"Truro" ,"Cumberland County" ,"New Glasgow" ,"Windsor" ,"East Hants" ,"New Minas" ,"Yarmouth" ,"Halifax" ,"Parrsboro"
											 };
	
	String[] cities_ON = {"Ajax" ,"Halton" ,"Peterborough" ,"Atikokan" ,"Halton Hills" ,"Pickering" ,"Barrie" ,"Hamilton" ,"Port Bruce" ,"Belleville" ,"Hamilton-Wentworth"
											 ,"Port Burwell" ,"Blandford-Blenheim" ,"Hearst" ,"Port Colborne" ,"Blind River" ,"Huntsville" ,"Port Hope" ,"Brampton" ,"Ingersoll" ,"Prince Edward"
											 ,"Brant" ,"James" ,"Quinte West" ,"Brantford" ,"Kanata" ,"Renfrew" ,"Brock" ,"Kincardine" ,"Richmond Hill" ,"Brockville" ,"King" ,"Sarnia"
											 ,"Burlington" ,"Kingston" ,"Sault Ste. Marie" ,"Caledon" ,"Kirkland Lake" ,"Scarborough" ,"Cambridge" ,"Kitchener" ,"Scugog" ,"Chatham-Kent"
											 ,"Larder Lake" ,"Souix Lookout CoC Sioux Lookout" ,"Chesterville" ,"Leamington" ,"Smiths Falls" ,"Clarington" ,"Lennox-Addington" ,"South-West Oxford"
											 ,"Cobourg" ,"Lincoln" ,"St. Catharines" ,"Cochrane" ,"Lindsay" ,"St. Thomas" ,"Collingwood" ,"London" ,"Stoney Creek" ,"Cornwall" ,"Loyalist Township"
											 ,"Stratford" ,"Cumberland" ,"Markham" ,"Sudbury" ,"Deep River" ,"Metro Toronto" ,"Temagami" ,"Dundas" ,"Merrickville" ,"Thorold" ,"Durham"
											 ,"Milton" ,"Thunder Bay" ,"Dymond" ,"Nepean" ,"Tillsonburg" ,"Ear Falls" ,"Newmarket" ,"Timmins" ,"East Gwillimbury" ,"Niagara" ,"Toronto"
											 ,"East Zorra-Tavistock" ,"Niagara Falls" ,"Uxbridge" ,"Elgin" ,"Niagara-on-the-Lake" ,"Vaughan" ,"Elliot Lake" ,"North Bay" ,"Wainfleet"
											 ,"Flamborough" ,"North Dorchester" ,"Wasaga Beach" ,"Fort Erie" ,"North Dumfries" ,"Waterloo" ,"Fort Frances" ,"North York" ,"Waterloo" ,"Gananoque"
											 ,"Norwich" ,"Welland" ,"Georgina" ,"Oakville" ,"Wellesley" ,"Glanbrook" ,"Orangeville" ,"West Carleton" ,"Gloucester" ,"Orillia" ,"West Lincoln"
											 ,"Goulbourn" ,"Osgoode" ,"Whitby" ,"Gravenhurst" ,"Oshawa" ,"Wilmot" ,"Grimsby" ,"Ottawa" ,"Windsor" ,"Guelph" ,"Ottawa-Carleton" ,"Woolwich"
											 ,"Haldimand-Norfork" ,"Owen Sound" ,"York"
											 };
	
	
	String[] cities_PE = {"Alberton" ,"Montague" ,"Stratford" ,"Charlottetown" ,"Souris" ,"Summerside" ,"Cornwall"};
	
	
	String[] cities_QC = {"Alma" ,"Fleurimont" ,"Longueuil" ,"Amos" ,"Gaspe" ,"Marieville" ,"Anjou" ,"Gatineau" ,"Mount Royal" ,"Aylmer" ,"Hull" ,"Montreal"
										   ,"Beauport" ,"Joliette" ,"Montreal Region" ,"Bromptonville" ,"Jonquiere" ,"Montreal-Est" ,"Brosssard" ,"Lachine" ,"Quebec" ,"Chateauguay"
										   ,"Lasalle" ,"Saint-Leonard" ,"Chicoutimi" ,"Laurentides" ,"Sherbrooke" ,"Coaticook" ,"LaSalle" ,"Sorel" ,"Coaticook" ,"Laval" ,"Thetford Mines"
										   ,"Dorval" ,"Lennoxville" ,"Victoriaville" ,"Drummondville" ,"Levis"
										   };
	
	
	String[] cities_SK = {"Avonlea" ,"Melfort" ,"Swift Current" ,"Colonsay" ,"Nipawin" ,"Tisdale" ,"Craik" ,"Prince Albert" ,"Unity" ,"Creighton" ,"Regina"
											 ,"Weyburn" ,"Eastend" ,"Saskatoon" ,"Wynyard" ,"Esterhazy" ,"Shell Lake" ,"Yorkton" ,"Gravelbourg"
											 };
	
	
	
	String cities_YT[] = {"Carcross" ,"Whitehorse"};
	
	//constructor
	public BA_Calculator_GUI()
	{
	 super("Bilal Al-Muhtadi S.N: 0957079");
	//boilerplate
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout() );
			this.setSize(1000,1000);
			this.setLocationRelativeTo(null);
			
			topPanel = new JPanel();
			topPanel.setLayout(new FlowLayout());
			topPanel.setBackground(Color.white);
			
			//create and add elements
			titleLbl = new JLabel("This is Bilal’s Student Loan Calculator");
			topPanel.add(titleLbl);
			
			this.add(topPanel, BorderLayout.NORTH);
			
			this.buildWestPanel();
			this.add(westPanel, BorderLayout.WEST);
			
			this.buildCenterPanel();
			this.add(centerPanel, BorderLayout.CENTER);
			
			this.buildEastPanel();
			this.add(eastPanel, BorderLayout.EAST);
			
			sbmtBtn = new JButton("submit");
			repaymentForm = new JButton("Repayment Form");
			
			JPanel buttonsPanel = new JPanel();
			
			buttonsPanel.add(repaymentForm);
			buttonsPanel.add(sbmtBtn);
			
			sbmtBtn.addActionListener(new submitBtnClass());
			repaymentForm.addActionListener(new repaymentBtnClass());
			
			buttonsPanel.setBackground(Color.white);
			this.add(buttonsPanel, BorderLayout.SOUTH);
			
			pack();
			
			
		//last line
			this.setVisible(true);
	}

	//method to create a west panel that will be added to the JFrame
	private void buildWestPanel()
	{
		westPanel = new JPanel();
		westPanel.setLayout(new BorderLayout());
		
		JPanel infoTable = new JPanel();
		infoTable.setLayout(new GridLayout(6,2,5,5));
		infoTable.setBackground(Color.white);
		
		JPanel infoColumnTitle = new JPanel();
		infoColumnTitle.setLayout(new FlowLayout());
		infoColumnTitle.setBackground(Color.white);
		
		JLabel studentInfo = new JLabel(" Student Info");
		infoColumnTitle.add(studentInfo);
		
		//create elements
		
		JLabel idLabel = new JLabel(" ID Number");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel firstNameLabel = new JLabel(" First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel middleNameLabel = new JLabel(" Middle Name ");
		middleNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel surnameLabel = new JLabel(" surname");
		surnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		idNum = new JTextField(10);
		firstNameTxt = new JTextField(10);
		middleNameTxt = new JTextField(10);
		surnameTxt = new JTextField(10);

		idNum.addKeyListener(new idNumClass());
		
		infoTable.add(idLabel);
		infoTable.add(idNum);
		infoTable.add(firstNameLabel);
		infoTable.add(firstNameTxt);
		infoTable.add(middleNameLabel);
		infoTable.add(middleNameTxt);
		infoTable.add(surnameLabel);
		infoTable.add(surnameTxt);
		
		westPanel.add(infoColumnTitle, BorderLayout.NORTH);
		westPanel.add(infoTable, BorderLayout.CENTER);
		
		
		
	}
	
//method to create a center panel that will be added to the JFrame
	private void buildCenterPanel()
	{
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		JPanel addressTable = new JPanel();
		addressTable.setLayout(new GridLayout(6,2,5,5));
		addressTable.setBackground(Color.white);
		
		JPanel addressColumnTitle = new JPanel();
		addressColumnTitle.setLayout(new FlowLayout());
		addressColumnTitle.setBackground(Color.white);
		
		JLabel addressLbl = new JLabel(" Address");
		addressColumnTitle.add(addressLbl);
		
		
		JLabel aptNumLbl = new JLabel(" Apartment Number ");
		aptNumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel streetNumLbl = new JLabel("Street Number ");
		streetNumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel streetNameLbl = new JLabel("Street Name ");
		streetNameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel cityLbl = new JLabel("City ");
		cityLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel provinceLbl = new JLabel("Province ");
		provinceLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel postalcodeLbl = new JLabel("Postal Code ");
		postalcodeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		aptNumTxt = new JTextField(7);
		streetNumTxt = new JTextField(7);
		streetNameTxt = new JTextField(7);
		postalcodeTxt = new JTextField(7);
		
		provinceBox = new JComboBox<String>(provinceArray);
		cityBox = new JComboBox();
		
		cityBox.setEditable(true);
		cityBox.setEnabled(false);
		
	  // Create an ActionListener for the JComboBox component.
		provinceBox.addActionListener(new provinceClass());
			
		addressTable.add(aptNumLbl);
		addressTable.add(aptNumTxt);
		addressTable.add(streetNumLbl);
		addressTable.add(streetNumTxt);
		addressTable.add(streetNameLbl);
		addressTable.add(streetNameTxt);
		addressTable.add(provinceLbl);
		addressTable.add(provinceBox);
		addressTable.add(cityLbl);
		addressTable.add(cityBox);
		addressTable.add(postalcodeLbl);
		addressTable.add(postalcodeTxt);
		
		centerPanel.add(addressColumnTitle, BorderLayout.NORTH);
		centerPanel.add(addressTable, BorderLayout.CENTER);
		
		
	
	}
	
	
//method to create an East panel that will be added to the JFrame
	private void buildEastPanel()
	{
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		
		JPanel loansTable = new JPanel();
		loansTable.setLayout(new GridLayout(6,2,5,5));
		loansTable.setBackground(Color.white);
		
		JPanel loansColumnTitle = new JPanel();
		loansColumnTitle.setLayout(new FlowLayout());
		loansColumnTitle.setBackground(Color.white);
		
		JLabel loansInfo = new JLabel(" Loans Info");
		loansColumnTitle.add(loansInfo);
		
		//create elements
		
		JLabel cslTypeLabel = new JLabel(" CSL Amount");
		cslTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel oslAmountLabel = new JLabel(" OSL Amount");
		oslAmountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cslTxt = new JTextField(10);
		oslTxt = new JTextField(7);

		//add the elements to the panel
		loansTable.add(cslTypeLabel);
		loansTable.add(cslTxt);
		loansTable.add(oslAmountLabel);
		loansTable.add(oslTxt);
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		loansTable.add(new JLabel(""));
		
		
		
		eastPanel.add(loansColumnTitle, BorderLayout.NORTH);
		eastPanel.add(loansTable, BorderLayout.CENTER);
		eastPanel.add(new JLabel("  "), BorderLayout.EAST);
		
		
	}
	
	//constructor for the Repayment Form
	private class RepayForm extends JFrame
	{
		RepayForm()
		{
			super("Bilal Al-Muhtadi S.N: 0957079");
			//boilerplate
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.setLayout(new BorderLayout() );
					this.setSize(1000,1000);
					this.setLocationRelativeTo(null);
					
					topPanel = new JPanel();
					topPanel.setLayout(new FlowLayout());
					topPanel.setBackground(Color.white);
					
					titleLbl = new JLabel("This is Bilal’s Student Loan Calculator");
					topPanel.add(titleLbl);
					
					this.add(topPanel, BorderLayout.NORTH);
					
					this.add(westPanel, BorderLayout.WEST);
					
					this.add(centerPanel, BorderLayout.CENTER);
					
					this.add(eastPanel, BorderLayout.EAST);
					
					previousBtn = new JButton("Previous");
					nextBtn = new JButton("Next");
					calculateBtn = new JButton("Calculate");
					
					JPanel buttonsPanel = new JPanel();
				
					
					previousBtn.addActionListener(new previous());
					nextBtn.addActionListener(new next());
					calculateBtn.addActionListener(new calcLoan());
					
					JLabel annualInterestRateLbl = new JLabel("Annual Interest Rate");
					
					wholeNumPercent =  new JComboBox();
					
					//loop to populate the wholeNumPercent Combo box
					for(int i=0;i<=100;i++) 
					{
						wholeNumPercent.addItem(i);
					}
					
					JLabel monthsLabel = new JLabel("amortization period in months");
					amortizationMonths = new JTextField(3);
					
					fractionPercent = new JComboBox(fractions);
					
					buttonsPanel.add(previousBtn);
					buttonsPanel.add(nextBtn);
					buttonsPanel.add(annualInterestRateLbl);
					buttonsPanel.add(wholeNumPercent);
					buttonsPanel.add(fractionPercent);
					buttonsPanel.add(monthsLabel);
					buttonsPanel.add(amortizationMonths);
					buttonsPanel.add(calculateBtn);
					
					
					buttonsPanel.setBackground(Color.white);
					this.add(buttonsPanel, BorderLayout.SOUTH);
					
					pack();
					
					//last line
					this.setVisible(true);
					
		}
		
	}
	
	//constructor for the results window
	private class ResultsWindow extends JFrame
	{
		ResultsWindow(String oslStr, String cslStr ,String combinedStr ,String totalStr, String orgBorrowedStr, String intRateAmntStr)
		{
			super("Results");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new GridLayout(6, 1) );
			this.setSize(1000,1000);
			this.setLocationRelativeTo(null);
			
			JTextField oslResultTxt = new JTextField();
			JTextField cslResultTxt = new JTextField();
			JTextField combinedResultTxt = new JTextField();
			JTextField totalResultTxt = new JTextField();
			JTextField originalResultTxt = new JTextField();
			JTextField intersetAmountResultsTxt = new JTextField();
			
			oslResultTxt.setText(oslStr);
			cslResultTxt.setText(cslStr);
			combinedResultTxt.setText(combinedStr);
			totalResultTxt.setText(totalStr);
			originalResultTxt.setText(orgBorrowedStr);
			intersetAmountResultsTxt.setText(intRateAmntStr);
			
			this.add(cslResultTxt);
			this.add(oslResultTxt);
			this.add(combinedResultTxt);
			this.add(totalResultTxt);
			this.add(originalResultTxt);
			this.add(intersetAmountResultsTxt);
			
			pack();
			
			//last line
			this.setVisible(true);
		}
	}
	
	//over-ride Interface method
	public double calculateLoanPayment(double loan, double primeIntRate, int months) 
	{
		double monthlyIntRate = primeIntRate * ANNUAL_RATE_TO_MONTHLY_RATE;
		double loanPayment = (loan)*(monthlyIntRate)*Math.pow((1+monthlyIntRate),months)/(Math.pow(1+monthlyIntRate, months)-1);
		return loanPayment;
	}
	
	
	private class idNumClass implements KeyListener{
	
	public void keyPressed(KeyEvent ke) 
	{
    String value = idNum.getText();
    
    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
    {
    	idNum.setEditable(true);
    } 
    else {
    	idNum.setEditable(false);
    }
    
  
 }

	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	
		
	}


	}
	
	
	//inner class for province JComboBox that will populate city JComboBox based on the province
	private class provinceClass implements ActionListener{
		
		
			public void actionPerformed(ActionEvent event) {
     		cityBox.setEnabled(true);
     		setCityBox(provinceBox, cityBox);
      }
		}
	
	
	
	
	//inner class for submit button that will add the student to the students array list
	private class submitBtnClass implements ActionListener{
		double oslAmount, cslAmount;
		
		public void actionPerformed(ActionEvent event) {
   		String idNumber = idNum.getText();
   		String firstName = firstNameTxt.getText();
   		String middleName = middleNameTxt.getText();
   		String surname = surnameTxt.getText();
   		String aptNumber = aptNumTxt.getText();
   		String streetNumber = streetNumTxt.getText();
   		String streetName = streetNameTxt.getText();
   		String city = (String) cityBox.getSelectedItem();
   		String province = (String) provinceBox.getSelectedItem();
   		String postalCode = postalcodeTxt.getText();
   		cslAmount = Double.parseDouble(cslTxt.getText());
   		oslAmount = Double.parseDouble(oslTxt.getText());
   		
   		try {
     		BA_NegativeValueException.checkLoan(cslAmount);
     		BA_NegativeValueException.checkLoan(oslAmount);
			}
			catch(BA_NegativeValueException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage()+"\nYou cannot enter negative values. converting negative number to positive");
			}
   		finally
   		{
   			cslAmount = Math.abs(cslAmount);
				oslAmount = Math.abs(oslAmount);
   		}
   
   		
   		Student newStudent = new Student(idNumber, surname, middleName, firstName, aptNumber, streetNumber, streetName, city, province, postalCode, cslAmount, oslAmount);
   		
   		students.add(newStudent);
   		
    }
	}//end class

//inner class for repayment button that will open the repaymentForm window	
private class repaymentBtnClass implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event) {
			new RepayForm();
			
		}
}//end class
	
//inner class for previous button
private class previous implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// cycle through all the options available 
		index--;
		
		if (index < 0) 
		{
			index = students.size() - 1;
		}
	
		idNum.setText(students.get(index).getStudentID());
		firstNameTxt.setText(students.get(index).getFirstName());
		middleNameTxt.setText(students.get(index).getMiddleName());
		surnameTxt.setText(students.get(index).getSurname());
		aptNumTxt.setText(students.get(index).getAptNumber());
		streetNumTxt.setText(students.get(index).getStreetNumber());
		streetNameTxt.setText(students.get(index).getStreetName());
		provinceBox.getEditor().setItem(students.get(index).getProvince());
		cityBox.getEditor().setItem(students.get(index).getCity());
		postalcodeTxt.setText(students.get(index).getPostalCode());
		cslTxt.setText(String.valueOf(students.get(index).getCslLoanAmount()));
		oslTxt.setText(String.valueOf(students.get(index).getOslLoanAmount()));
		
		//refresh the data on the GUI
		SwingUtilities.updateComponentTreeUI(westPanel);
		SwingUtilities.updateComponentTreeUI(centerPanel);
		SwingUtilities.updateComponentTreeUI(eastPanel);
	}
	
}//end class



//inner class for next button
	private class next implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		index++;
		if (index >= students.size()) {
			index = 0;
		}
		
		
		idNum.setText(students.get(index).getStudentID());
		firstNameTxt.setText(students.get(index).getFirstName());
		middleNameTxt.setText(students.get(index).getMiddleName());
		surnameTxt.setText(students.get(index).getSurname());
		aptNumTxt.setText(students.get(index).getAptNumber());
		streetNumTxt.setText(students.get(index).getStreetNumber());
		streetNameTxt.setText(students.get(index).getStreetName());
		provinceBox.getEditor().setItem(students.get(index).getProvince());
		cityBox.getEditor().setItem(students.get(index).getCity());
		postalcodeTxt.setText(students.get(index).getPostalCode());
		cslTxt.setText(String.valueOf(students.get(index).getCslLoanAmount()));
		oslTxt.setText(String.valueOf(students.get(index).getOslLoanAmount()));
		
		//refresh the data on the GUI
		SwingUtilities.updateComponentTreeUI(westPanel);
		SwingUtilities.updateComponentTreeUI(centerPanel);
		SwingUtilities.updateComponentTreeUI(eastPanel);
	}
	
}
//inner class for calculate button
	private class calcLoan implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			int wholeNum = (int)wholeNumPercent.getSelectedItem();
			String fracString = (String)fractionPercent.getSelectedItem();
			double fracNum = Double.parseDouble(fracString);
			
			double annualIntRate = (wholeNum + fracNum);
			
			double cslAmount = students.get(index).getCslLoanAmount();
			double oslAmount = students.get(index).getOslLoanAmount();
			
			int months = Integer.parseInt(amortizationMonths.getText());
			
			double cslIntRate = annualIntRate + 2.5;
			double oslIntRate = annualIntRate + 1;
			
			double oslLoanPayment = (double)Math.round(calculateLoanPayment(oslAmount, oslIntRate, months)* 100) / 100;

			double cslLoanPayment = (double)Math.round(calculateLoanPayment(cslAmount, cslIntRate, months)* 100) / 100;
			
			double combinedMonthlyPayment = oslLoanPayment + cslLoanPayment;
			
			double totAmntToRepay = combinedMonthlyPayment * months;
			totAmntToRepay = (double)Math.round(totAmntToRepay* 100) / 100;
			
			
			double originalAmountBorrowed = oslAmount+cslAmount;
			originalAmountBorrowed = (double)Math.round(originalAmountBorrowed* 100) / 100;
			
			double intRateToBePaid = totAmntToRepay - originalAmountBorrowed;
			intRateToBePaid = (double)Math.round(intRateToBePaid* 100) / 100;
			
			String oslResult = "CSL monthly payments: " + cslLoanPayment ;
			String cslResult = "OSL monthly payments: " + oslLoanPayment;
			String combinedResult = "Combined Monthly Payment: " + combinedMonthlyPayment;
			String totalResult = "Amount that will be repaid with interest: " + totAmntToRepay;
			String orgResult = "Original Amount Borrowed: " + originalAmountBorrowed;
			String totalIntRateResult = "Total amount of interest that is paid: " + intRateToBePaid;
			
			//create new window for result
			new ResultsWindow(oslResult, cslResult, combinedResult, totalResult, orgResult, totalIntRateResult);
		}
	}//end class
	

	/*
	 * Method Name: setCityBox()
	 * Purpose: will populate city JComboBox based on province JComboBox
	 * Accepts: province JComboBox and city JComboBox
	 * Returns: nothing
	 * Date: Apr 12, 2020
	 */
	private void setCityBox(JComboBox<String> proviceBox, JComboBox<String> cityBox)
	{
		String selectedProvince = (String) provinceBox.getSelectedItem();
 		
 		switch(selectedProvince)
 		{
 		case "Alberta":
 			java.util.Arrays.sort(cities_AB);
 			final DefaultComboBoxModel<String> modelAB = new DefaultComboBoxModel<String>(cities_AB);
 			cityBox.setModel(modelAB);
 			break;
 			
 		case "British Columbia":
 			java.util.Arrays.sort(cities_BC);
 			final DefaultComboBoxModel<String> modelBC = new DefaultComboBoxModel<String>(cities_BC);
 			cityBox.setModel(modelBC);
 			break;
 			
 		case "Manitoba":
 			java.util.Arrays.sort(cities_MB);
 			final DefaultComboBoxModel<String> modelMB = new DefaultComboBoxModel<String>(cities_MB);
 			cityBox.setModel(modelMB);
 			break;
 			
 		case "New Brunswick":
 			java.util.Arrays.sort(cities_NB);
 			final DefaultComboBoxModel<String> modelNB = new DefaultComboBoxModel<String>(cities_NB);
 			cityBox.setModel(modelNB);
 			break;
 			
 		case "Newfoundland and Labrador":
 			java.util.Arrays.sort(cities_NL);
 			final DefaultComboBoxModel<String> modelNL = new DefaultComboBoxModel<String>(cities_NL);
 			cityBox.setModel(modelNL);
 			break;
 			
 		case "Northwest Territories":
 			java.util.Arrays.sort(cities_NT);
 			final DefaultComboBoxModel<String> modelNT = new DefaultComboBoxModel<String>(cities_NT);
 			cityBox.setModel(modelNT);
 			break;
 			
 		case "Nova Scotia":
 			java.util.Arrays.sort(cities_NS);
 			final DefaultComboBoxModel<String> modelNS = new DefaultComboBoxModel<String>(cities_NS);
 			cityBox.setModel(modelNS);
 			break;
 			
 		case "Nunavut":
 			java.util.Arrays.sort(cities_NT);
 			//final DefaultComboBoxModel<String> modelNT = new DefaultComboBoxModel<String>(cities_NT);
 			//cityBox.setModel(modelNT);
 			break;
 			
 		case "Ontario":
 			java.util.Arrays.sort(cities_ON);
 			final DefaultComboBoxModel<String> modelON = new DefaultComboBoxModel<String>(cities_ON);
 			cityBox.setModel(modelON);
 			break;
 			
 		case "Prince Edward Island":
 			java.util.Arrays.sort(cities_PE);
 			final DefaultComboBoxModel<String> modelPE = new DefaultComboBoxModel<String>(cities_PE);
 			cityBox.setModel(modelPE);
 			break;
 			
 		case "Quebec":
 			java.util.Arrays.sort(cities_QC);
 			final DefaultComboBoxModel<String> modelQC = new DefaultComboBoxModel<String>(cities_QC);
 			cityBox.setModel(modelQC);
 			break;
 			
 		case "Saskatchewan":
 			java.util.Arrays.sort(cities_SK);
 			final DefaultComboBoxModel<String> modelSK = new DefaultComboBoxModel<String>(cities_SK);
 			cityBox.setModel(modelSK);
 			break;
 			
 		case "Yukon Territory":
 			java.util.Arrays.sort(cities_YT);
 			final DefaultComboBoxModel<String> modelYT = new DefaultComboBoxModel<String>(cities_YT);
 			cityBox.setModel(modelYT);
 			break;
 			
 		}//end switch
  }//end method
	
	public static void main(String[] args)
	{
		new BA_Calculator_GUI();
	}
	//end main
}
//end class