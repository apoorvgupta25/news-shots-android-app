package com.apoorvgupta.home.models.refreshdata

import com.google.gson.annotations.SerializedName

data class RefreshData(

    @SerializedName("Campania")
    val campaign: Int?,

    @SerializedName("CodigoConsultora")
    val consultoraCode: String?,

    @SerializedName("CodigoPrograma")
    val programCode: String?,

    @SerializedName("CodigoZona")
    val zoneCode: String?,

    @SerializedName("CodigoUsuario")
    val userCode: String?,

    @SerializedName("ConsecutivoNueva")
    val consecutiveNew: Int?,

    @SerializedName("ConsultoraAsociada")
    val associateConsultora: String?,

    @SerializedName("ConsultoraAsociadaID")
    val associateConsultoraId: Int?,

    @SerializedName("ConsultoraID")
    val consultoraID: Int?,

    @SerializedName("ConsultoraNueva")
    val consultoraNew: Int?,

    @SerializedName("DiaFacturacion")
    val billingDay: Int?,

    @SerializedName("FechaFinFacturacion")
    val billingEndDate: String?,

    @SerializedName("FechaInicioFacturacion")
    val billingStartDate: String?,

    @SerializedName("Lider")
    val leader: Int?,

    @SerializedName("MontoTotalPedidoAnterior")
    val lastOrderTotalAmount: Double?,

    @SerializedName("PaisID")
    val countryId: Int?,

    @SerializedName("PaisISO")
    val countryIso: String?,

    @SerializedName("RDActivoMdo")
    val rDActivoMdo: Boolean?,

    @SerializedName("RDEsActiva")
    val rDEsActiva: Boolean?,

    @SerializedName("RDEsSuscrita")
    val rDEsSuscrita: Boolean?,

    @SerializedName("RDTieneRDC")
    val rDTieneRDC: Boolean?,

    @SerializedName("RDTieneRDCR")
    val rDTieneRDCR: Boolean?,

    @SerializedName("RDTieneRDI")
    val rDTieneRDI: Boolean?,

    @SerializedName("RegionID")
    val regionID: Int?,

    @SerializedName("CodigoRegion")
    val regionCode: String?,

    @SerializedName("Simbolo")
    val currencySymbol: String?,

    @SerializedName("UsuarioPrueba")
    val isTestUser: Boolean?,

    @SerializedName("ZonaHoraria")
    val timeZone: Double?,

    @SerializedName("ZonaID")
    val zoneId: Int?,

    @SerializedName("FotoPerfil")
    val profileImageURL: String?,

    @SerializedName("NombreConsultora")
    val consultantName: String?,

    @SerializedName("Sobrenombre")
    val nickName: String?,

    @SerializedName("Periodo")
    val period: String?,

    @SerializedName("MontoMaximoPedido")
    val maximumOrderAmount: Double?,

    @SerializedName("NroCampanias")
    val numberOfCampaigns: Int?,

    @SerializedName("CodigoSeccion")
    val sectionCode: String?,

    @SerializedName("EsUltimoDiaFacturacion")
    val isLastDayOfBilling: Boolean?,

    @SerializedName("PagoContado")
    val cashPayment: Boolean?,

    @SerializedName("DiaProl")
    val prolDay: Boolean?,

    @SerializedName("SegmentoInternoID")
    val internalSegmentID: Int?,

    @SerializedName("MontoMinimoPedido")
    val minimumOrderAmount: Double?,

    @SerializedName("ValidacionAbierta")
    val isOpenValidation: Boolean?,

    @SerializedName("EsBrillante")
    val brilliant: Boolean?,

    @SerializedName("NumeroDocumento")
    val documentNumber: String?,

    @SerializedName("ValidacionInteractiva")
    val isInteractiveValidation: Boolean?,

    @SerializedName("CodigosConcursos")
    val contestCodes: String?,

    @SerializedName("AceptacionConsultoraDA")
    val aceptacionConsultoraDA: Int?,

    @SerializedName("ZonaValida")
    val isValidZone: Boolean?,

    @SerializedName("HoraCierreNoFacturable")
    val nonBillableClosingTime: String?,

    @SerializedName("HoraFinPortal")
    val timeEndPortal: String?,

    @SerializedName("FacturarPedidoFM")
    val invoiceOrderFM: Boolean?,

    @SerializedName("DiasCierre")
    val closingDays: Int?,

    @SerializedName("DiasAntes")
    val beforeDays: Int?,

    @SerializedName("HoraInicioNoFacturable")
    val nonBillableStartTime: String?,

    @SerializedName("HoraInicio")
    val startTime: String?,

    @SerializedName("HoraFin")
    val endTime: String?,

    @SerializedName("PROLSinStock")
    val isPROLSinStock: Boolean?,

    @SerializedName("MontoMaximoDesviacion")
    val maximumAmountDeviation: Double?,

    @SerializedName("IndicadorGPRSB")
    val indicatorGPRSB: Int?,

    @SerializedName("TipoUsuario")
    val userType: Int?,

)
