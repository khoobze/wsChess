
package m1.tp.javaee.webservice.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the m1.tp.javaee.webservice.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MovePieceResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "movePieceResponse");
    private final static QName _RemovePartieResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "removePartieResponse");
    private final static QName _CreateEchiquier_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "createEchiquier");
    private final static QName _LoginResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "loginResponse");
    private final static QName _SaveEchiquier_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "saveEchiquier");
    private final static QName _GetHistoriqueResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getHistoriqueResponse");
    private final static QName _GetJoueur_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getJoueur");
    private final static QName _RemovePartie_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "removePartie");
    private final static QName _SubscribeResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "subscribeResponse");
    private final static QName _GetPartiesResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getPartiesResponse");
    private final static QName _LoadEchiquier_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "loadEchiquier");
    private final static QName _JoinPartiesResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "joinPartiesResponse");
    private final static QName _CreateEchiquierResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "createEchiquierResponse");
    private final static QName _LoadEchiquierResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "loadEchiquierResponse");
    private final static QName _GetEchiquierResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getEchiquierResponse");
    private final static QName _Subscribe_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "subscribe");
    private final static QName _JoinEchiquier_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "joinEchiquier");
    private final static QName _JoinEchiquierResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "joinEchiquierResponse");
    private final static QName _MovePiece_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "movePiece");
    private final static QName _JoinParties_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "joinParties");
    private final static QName _Login_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "login");
    private final static QName _GetParties_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getParties");
    private final static QName _GetHistorique_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getHistorique");
    private final static QName _SaveEchiquierResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "saveEchiquierResponse");
    private final static QName _GetEchiquier_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getEchiquier");
    private final static QName _GetJoueurResponse_QNAME = new QName("http://server.webservice.javaee.tp.m1/", "getJoueurResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: m1.tp.javaee.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetParties }
     * 
     */
    public GetParties createGetParties() {
        return new GetParties();
    }

    /**
     * Create an instance of {@link GetJoueurResponse }
     * 
     */
    public GetJoueurResponse createGetJoueurResponse() {
        return new GetJoueurResponse();
    }

    /**
     * Create an instance of {@link GetEchiquier }
     * 
     */
    public GetEchiquier createGetEchiquier() {
        return new GetEchiquier();
    }

    /**
     * Create an instance of {@link SaveEchiquierResponse }
     * 
     */
    public SaveEchiquierResponse createSaveEchiquierResponse() {
        return new SaveEchiquierResponse();
    }

    /**
     * Create an instance of {@link GetHistorique }
     * 
     */
    public GetHistorique createGetHistorique() {
        return new GetHistorique();
    }

    /**
     * Create an instance of {@link JoinEchiquier }
     * 
     */
    public JoinEchiquier createJoinEchiquier() {
        return new JoinEchiquier();
    }

    /**
     * Create an instance of {@link Subscribe }
     * 
     */
    public Subscribe createSubscribe() {
        return new Subscribe();
    }

    /**
     * Create an instance of {@link GetEchiquierResponse }
     * 
     */
    public GetEchiquierResponse createGetEchiquierResponse() {
        return new GetEchiquierResponse();
    }

    /**
     * Create an instance of {@link LoadEchiquierResponse }
     * 
     */
    public LoadEchiquierResponse createLoadEchiquierResponse() {
        return new LoadEchiquierResponse();
    }

    /**
     * Create an instance of {@link JoinParties }
     * 
     */
    public JoinParties createJoinParties() {
        return new JoinParties();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link JoinEchiquierResponse }
     * 
     */
    public JoinEchiquierResponse createJoinEchiquierResponse() {
        return new JoinEchiquierResponse();
    }

    /**
     * Create an instance of {@link MovePiece }
     * 
     */
    public MovePiece createMovePiece() {
        return new MovePiece();
    }

    /**
     * Create an instance of {@link SaveEchiquier }
     * 
     */
    public SaveEchiquier createSaveEchiquier() {
        return new SaveEchiquier();
    }

    /**
     * Create an instance of {@link GetJoueur }
     * 
     */
    public GetJoueur createGetJoueur() {
        return new GetJoueur();
    }

    /**
     * Create an instance of {@link GetHistoriqueResponse }
     * 
     */
    public GetHistoriqueResponse createGetHistoriqueResponse() {
        return new GetHistoriqueResponse();
    }

    /**
     * Create an instance of {@link CreateEchiquier }
     * 
     */
    public CreateEchiquier createCreateEchiquier() {
        return new CreateEchiquier();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link JoinPartiesResponse }
     * 
     */
    public JoinPartiesResponse createJoinPartiesResponse() {
        return new JoinPartiesResponse();
    }

    /**
     * Create an instance of {@link CreateEchiquierResponse }
     * 
     */
    public CreateEchiquierResponse createCreateEchiquierResponse() {
        return new CreateEchiquierResponse();
    }

    /**
     * Create an instance of {@link RemovePartie }
     * 
     */
    public RemovePartie createRemovePartie() {
        return new RemovePartie();
    }

    /**
     * Create an instance of {@link GetPartiesResponse }
     * 
     */
    public GetPartiesResponse createGetPartiesResponse() {
        return new GetPartiesResponse();
    }

    /**
     * Create an instance of {@link LoadEchiquier }
     * 
     */
    public LoadEchiquier createLoadEchiquier() {
        return new LoadEchiquier();
    }

    /**
     * Create an instance of {@link SubscribeResponse }
     * 
     */
    public SubscribeResponse createSubscribeResponse() {
        return new SubscribeResponse();
    }

    /**
     * Create an instance of {@link MovePieceResponse }
     * 
     */
    public MovePieceResponse createMovePieceResponse() {
        return new MovePieceResponse();
    }

    /**
     * Create an instance of {@link RemovePartieResponse }
     * 
     */
    public RemovePartieResponse createRemovePartieResponse() {
        return new RemovePartieResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovePieceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "movePieceResponse")
    public JAXBElement<MovePieceResponse> createMovePieceResponse(MovePieceResponse value) {
        return new JAXBElement<MovePieceResponse>(_MovePieceResponse_QNAME, MovePieceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePartieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "removePartieResponse")
    public JAXBElement<RemovePartieResponse> createRemovePartieResponse(RemovePartieResponse value) {
        return new JAXBElement<RemovePartieResponse>(_RemovePartieResponse_QNAME, RemovePartieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEchiquier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "createEchiquier")
    public JAXBElement<CreateEchiquier> createCreateEchiquier(CreateEchiquier value) {
        return new JAXBElement<CreateEchiquier>(_CreateEchiquier_QNAME, CreateEchiquier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEchiquier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "saveEchiquier")
    public JAXBElement<SaveEchiquier> createSaveEchiquier(SaveEchiquier value) {
        return new JAXBElement<SaveEchiquier>(_SaveEchiquier_QNAME, SaveEchiquier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoriqueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getHistoriqueResponse")
    public JAXBElement<GetHistoriqueResponse> createGetHistoriqueResponse(GetHistoriqueResponse value) {
        return new JAXBElement<GetHistoriqueResponse>(_GetHistoriqueResponse_QNAME, GetHistoriqueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJoueur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getJoueur")
    public JAXBElement<GetJoueur> createGetJoueur(GetJoueur value) {
        return new JAXBElement<GetJoueur>(_GetJoueur_QNAME, GetJoueur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePartie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "removePartie")
    public JAXBElement<RemovePartie> createRemovePartie(RemovePartie value) {
        return new JAXBElement<RemovePartie>(_RemovePartie_QNAME, RemovePartie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "subscribeResponse")
    public JAXBElement<SubscribeResponse> createSubscribeResponse(SubscribeResponse value) {
        return new JAXBElement<SubscribeResponse>(_SubscribeResponse_QNAME, SubscribeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPartiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getPartiesResponse")
    public JAXBElement<GetPartiesResponse> createGetPartiesResponse(GetPartiesResponse value) {
        return new JAXBElement<GetPartiesResponse>(_GetPartiesResponse_QNAME, GetPartiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadEchiquier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "loadEchiquier")
    public JAXBElement<LoadEchiquier> createLoadEchiquier(LoadEchiquier value) {
        return new JAXBElement<LoadEchiquier>(_LoadEchiquier_QNAME, LoadEchiquier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinPartiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "joinPartiesResponse")
    public JAXBElement<JoinPartiesResponse> createJoinPartiesResponse(JoinPartiesResponse value) {
        return new JAXBElement<JoinPartiesResponse>(_JoinPartiesResponse_QNAME, JoinPartiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEchiquierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "createEchiquierResponse")
    public JAXBElement<CreateEchiquierResponse> createCreateEchiquierResponse(CreateEchiquierResponse value) {
        return new JAXBElement<CreateEchiquierResponse>(_CreateEchiquierResponse_QNAME, CreateEchiquierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadEchiquierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "loadEchiquierResponse")
    public JAXBElement<LoadEchiquierResponse> createLoadEchiquierResponse(LoadEchiquierResponse value) {
        return new JAXBElement<LoadEchiquierResponse>(_LoadEchiquierResponse_QNAME, LoadEchiquierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEchiquierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getEchiquierResponse")
    public JAXBElement<GetEchiquierResponse> createGetEchiquierResponse(GetEchiquierResponse value) {
        return new JAXBElement<GetEchiquierResponse>(_GetEchiquierResponse_QNAME, GetEchiquierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "subscribe")
    public JAXBElement<Subscribe> createSubscribe(Subscribe value) {
        return new JAXBElement<Subscribe>(_Subscribe_QNAME, Subscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinEchiquier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "joinEchiquier")
    public JAXBElement<JoinEchiquier> createJoinEchiquier(JoinEchiquier value) {
        return new JAXBElement<JoinEchiquier>(_JoinEchiquier_QNAME, JoinEchiquier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinEchiquierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "joinEchiquierResponse")
    public JAXBElement<JoinEchiquierResponse> createJoinEchiquierResponse(JoinEchiquierResponse value) {
        return new JAXBElement<JoinEchiquierResponse>(_JoinEchiquierResponse_QNAME, JoinEchiquierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovePiece }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "movePiece")
    public JAXBElement<MovePiece> createMovePiece(MovePiece value) {
        return new JAXBElement<MovePiece>(_MovePiece_QNAME, MovePiece.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinParties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "joinParties")
    public JAXBElement<JoinParties> createJoinParties(JoinParties value) {
        return new JAXBElement<JoinParties>(_JoinParties_QNAME, JoinParties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getParties")
    public JAXBElement<GetParties> createGetParties(GetParties value) {
        return new JAXBElement<GetParties>(_GetParties_QNAME, GetParties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistorique }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getHistorique")
    public JAXBElement<GetHistorique> createGetHistorique(GetHistorique value) {
        return new JAXBElement<GetHistorique>(_GetHistorique_QNAME, GetHistorique.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEchiquierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "saveEchiquierResponse")
    public JAXBElement<SaveEchiquierResponse> createSaveEchiquierResponse(SaveEchiquierResponse value) {
        return new JAXBElement<SaveEchiquierResponse>(_SaveEchiquierResponse_QNAME, SaveEchiquierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEchiquier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getEchiquier")
    public JAXBElement<GetEchiquier> createGetEchiquier(GetEchiquier value) {
        return new JAXBElement<GetEchiquier>(_GetEchiquier_QNAME, GetEchiquier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJoueurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.javaee.tp.m1/", name = "getJoueurResponse")
    public JAXBElement<GetJoueurResponse> createGetJoueurResponse(GetJoueurResponse value) {
        return new JAXBElement<GetJoueurResponse>(_GetJoueurResponse_QNAME, GetJoueurResponse.class, null, value);
    }

}
