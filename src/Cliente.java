

public class Cliente {
	private int id;
    private String Nome,Cpf,Email,DataNascimento;
    private Login login = new Login();
    
    
   
   
    public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 public String getNome() {
	        return this.Nome;
	    }

	public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getCpf() {
        return this.Cpf;
    }
    
    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    public String getEmail() {
        return this.Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getDataNascimento() {
        return this.DataNascimento;
    }
    
    public void setDataNascimentoo(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
    
    
    
    public String Cadastrar() {
        return "";
    }
    
    public String EditarCliente() {
        return "";
    }
    public String ComprarPassagem() {
        return "";
    }
    
    
}

