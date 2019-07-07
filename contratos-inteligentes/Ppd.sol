pragma solidity >=0.4.22 <0.6.0;
pragma experimental ABIEncoderV2;
contract PPD {
    struct Turma {
        string nome;
        string telefone;
        bool matriculado;
        uint presencas;
    }
    
    struct Chamada {
        uint data;
        bool situacao;
    }
    
    address professor;
    
    mapping(address => Chamada[]) chamada;
    mapping(address => Turma) public turma;
    
    constructor() public {
        professor = msg.sender;
    }
    
    function fazerMatricula (string memory nome, string memory telefone) public {
        require(professor != msg.sender, "Professor não pode se matricular na turma!");
        require(!ehMatriculado() , "Aluno já está matriculado.");
        Turma memory entrada;
        address aluno = msg.sender;
        entrada.nome = nome;
        entrada.telefone = telefone;
        entrada.matriculado = true;
        entrada.presencas = 0;
        turma[aluno] = entrada;
    }
    
    function fazerChamada (address aluno, bool situacao) public {
        require(professor == msg.sender, "Chamada deve ser feita pelo professor!");
        require(turma[aluno].matriculado, "Aluno não matriculado");
        Chamada memory entrada;
        
        entrada.data = now;
        entrada.situacao = situacao;
        chamada[aluno].push(entrada);
        if (situacao) {
            turma[aluno].presencas += 1;
        }
    }
    
    function ehMatriculado() public returns (bool _ret)
    {
        address aluno = msg.sender;
        _ret = turma[aluno].matriculado;
      
    }
    
    function obtemChamada(address aluno) public returns ( uint _presencas , Chamada [] memory _cham) {
        require(turma[aluno].matriculado, "Aluno não matriculado");
        require(professor == msg.sender, "Somente professor tem acesso a esta funcionalidade");
        _presencas = turma[aluno].presencas;
        _cham = chamada[aluno];
    }
   
    
}
