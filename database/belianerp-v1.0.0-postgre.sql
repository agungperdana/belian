--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2024-05-22 19:29:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5529 (class 1262 OID 16399)
-- Name: belian; Type: DATABASE; Schema: -; Owner: belian
--

CREATE DATABASE belian WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE belian OWNER TO belian;

\connect belian

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 26963)
-- Name: belian; Type: SCHEMA; Schema: -; Owner: belian
--

CREATE SCHEMA belian;


ALTER SCHEMA belian OWNER TO belian;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 317 (class 1259 OID 30714)
-- Name: access_module; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.access_module (
    id text NOT NULL,
    code text,
    name text,
    note text,
    module_group text DEFAULT 'GENERAL'::text,
    is_enabled character(1) DEFAULT '1'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.access_module OWNER TO belian;

--
-- TOC entry 455 (class 1259 OID 32078)
-- Name: access_user; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.access_user (
    id text NOT NULL,
    email text,
    password text,
    is_enabled character(1) DEFAULT '1'::bpchar,
    fk_user_setting text,
    is_deleteable character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.access_user OWNER TO belian;

--
-- TOC entry 215 (class 1259 OID 28344)
-- Name: accounting_period; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.accounting_period (
    id text NOT NULL,
    number text,
    name text,
    date_from date,
    date_to date,
    month text DEFAULT 'January'::text,
    fk_accounting_period_parent text,
    version bigint
);


ALTER TABLE belian.accounting_period OWNER TO belian;

--
-- TOC entry 216 (class 1259 OID 28352)
-- Name: acknowledgement; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.acknowledgement (
    id text NOT NULL,
    date date,
    approver_status text,
    person_id text,
    person_value text DEFAULT '0'::text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.acknowledgement OWNER TO belian;

--
-- TOC entry 217 (class 1259 OID 28361)
-- Name: address; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.address (
    id text NOT NULL,
    address text,
    postal text,
    status character(1) DEFAULT '1'::bpchar,
    type text DEFAULT 'HOME'::text,
    fk_city text,
    fk_province text,
    fk_country text,
    fk_party text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.address OWNER TO belian;

--
-- TOC entry 218 (class 1259 OID 28371)
-- Name: approve_and_reviewable; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.approve_and_reviewable (
    id text NOT NULL,
    number text,
    fk_organization_requested text,
    fk_last_status text,
    comment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.approve_and_reviewable OWNER TO belian;

--
-- TOC entry 219 (class 1259 OID 28379)
-- Name: asset; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.asset (
    id text NOT NULL,
    code text,
    name text,
    acquired_date date,
    last_serviced_date date,
    next_serviced_date date,
    buying_price numeric(10,0) DEFAULT NULL::numeric,
    is_active character(1) DEFAULT '1'::bpchar,
    is_disposed character(1) DEFAULT '0'::bpchar,
    fk_asset_type text,
    note text,
    fk_organization text,
    fk_cashier_shift text,
    version bigint
);


ALTER TABLE belian.asset OWNER TO belian;

--
-- TOC entry 220 (class 1259 OID 28389)
-- Name: asset_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.asset_type (
    id text NOT NULL,
    code text,
    name text,
    parent text,
    version bigint
);


ALTER TABLE belian.asset_type OWNER TO belian;

--
-- TOC entry 221 (class 1259 OID 28396)
-- Name: audit_trail; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.audit_trail (
    id text NOT NULL,
    date text,
    type text,
    username text,
    company text,
    service text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.audit_trail OWNER TO belian;

--
-- TOC entry 222 (class 1259 OID 28404)
-- Name: auto_journal_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.auto_journal_sales (
    id text NOT NULL,
    fk_cash_account text,
    fk_service_sales_account text,
    fk_goods_sales_account text,
    fk_tax_sales_account text,
    fk_receivable_account text,
    fk_tuslah_payable_account text,
    fk_branch_cash_account text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.auto_journal_sales OWNER TO belian;

--
-- TOC entry 223 (class 1259 OID 28412)
-- Name: benefit; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.benefit (
    id text NOT NULL,
    start date,
    end_date date,
    cost numeric(10,0) DEFAULT NULL::numeric,
    percent_employer_paid numeric(10,0) DEFAULT NULL::numeric,
    available_time bigint,
    fk_benefit_type text,
    period_type text,
    fk_employment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.benefit OWNER TO belian;

--
-- TOC entry 224 (class 1259 OID 28422)
-- Name: benefit_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.benefit_type (
    id text NOT NULL,
    code text,
    name text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.benefit_type OWNER TO belian;

--
-- TOC entry 225 (class 1259 OID 28430)
-- Name: billable; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.billable (
    id text NOT NULL,
    date date,
    number text,
    is_paid character(1) DEFAULT '0'::bpchar,
    fk_currency text,
    fk_organization text,
    fk_person_sales text,
    fk_person_customer text,
    fk_tax text,
    fk_cashier_shift text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.billable OWNER TO belian;

--
-- TOC entry 226 (class 1259 OID 28439)
-- Name: bpjs; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.bpjs (
    id text NOT NULL,
    card_number text,
    is_active character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.bpjs OWNER TO belian;

--
-- TOC entry 227 (class 1259 OID 28448)
-- Name: budget; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget (
    id text NOT NULL,
    start date,
    end_date date,
    type text DEFAULT 'Operating'::text
);


ALTER TABLE belian.budget OWNER TO belian;

--
-- TOC entry 228 (class 1259 OID 28456)
-- Name: budget_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_item (
    id text NOT NULL,
    budget_item_sequence integer,
    purpose text,
    justification text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_budget text,
    version bigint
);


ALTER TABLE belian.budget_item OWNER TO belian;

--
-- TOC entry 229 (class 1259 OID 28464)
-- Name: budget_review; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_review (
    id text NOT NULL,
    fk_budget text
);


ALTER TABLE belian.budget_review OWNER TO belian;

--
-- TOC entry 230 (class 1259 OID 28471)
-- Name: budget_revision; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_revision (
    id text NOT NULL,
    budget_revision_sequence integer,
    date date,
    fk_budget text,
    comment text,
    version bigint
);


ALTER TABLE belian.budget_revision OWNER TO belian;

--
-- TOC entry 231 (class 1259 OID 28478)
-- Name: budget_revision_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_revision_item (
    id text NOT NULL,
    budget_revision_item_type text,
    fk_budget_item text,
    fk_budget_revision text,
    note text,
    version bigint
);


ALTER TABLE belian.budget_revision_item OWNER TO belian;

--
-- TOC entry 232 (class 1259 OID 28485)
-- Name: budget_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_role (
    id text NOT NULL,
    fk_budget text
);


ALTER TABLE belian.budget_role OWNER TO belian;

--
-- TOC entry 233 (class 1259 OID 28492)
-- Name: budget_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.budget_status (
    id text NOT NULL,
    fk_budget text
);


ALTER TABLE belian.budget_status OWNER TO belian;

--
-- TOC entry 234 (class 1259 OID 28499)
-- Name: carier_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.carier_relationship (
    id text NOT NULL,
    fk_carrier text,
    fk_organization text
);


ALTER TABLE belian.carier_relationship OWNER TO belian;

--
-- TOC entry 235 (class 1259 OID 28506)
-- Name: carrier; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.carrier (
    id text NOT NULL
);


ALTER TABLE belian.carrier OWNER TO belian;

--
-- TOC entry 236 (class 1259 OID 28513)
-- Name: cash_purchase_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.cash_purchase_order (
    id text NOT NULL,
    fk_facility text
);


ALTER TABLE belian.cash_purchase_order OWNER TO belian;

--
-- TOC entry 237 (class 1259 OID 28520)
-- Name: cash_purchase_order_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.cash_purchase_order_item (
    id text NOT NULL,
    fk_cash_purchase_order text
);


ALTER TABLE belian.cash_purchase_order_item OWNER TO belian;

--
-- TOC entry 238 (class 1259 OID 28527)
-- Name: cash_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.cash_sales (
    id text NOT NULL,
    table_number integer DEFAULT 1,
    fk_geographic_location text,
    note text,
    cash_sales_type text
);


ALTER TABLE belian.cash_sales OWNER TO belian;

--
-- TOC entry 239 (class 1259 OID 28535)
-- Name: cash_sales_line; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.cash_sales_line (
    id text NOT NULL,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_unit_of_measure text,
    fk_product text,
    fk_cash_sales text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.cash_sales_line OWNER TO belian;

--
-- TOC entry 240 (class 1259 OID 28547)
-- Name: cashier_shift; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.cashier_shift (
    id text NOT NULL,
    cashier_shift_date date,
    employee text,
    is_closed character(1) DEFAULT '0'::bpchar,
    asset text,
    capital numeric(10,0) DEFAULT NULL::numeric,
    cashier_shift_start time without time zone,
    cashier_shift_end time without time zone,
    version bigint DEFAULT 0
);


ALTER TABLE belian.cashier_shift OWNER TO belian;

--
-- TOC entry 241 (class 1259 OID 28557)
-- Name: citizenship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.citizenship (
    id text NOT NULL,
    citizenship_start date,
    citizenship_end_date date,
    nopassport text,
    fk_person text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.citizenship OWNER TO belian;

--
-- TOC entry 242 (class 1259 OID 28565)
-- Name: clinic_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.clinic_sales (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text,
    medication_status text
);


ALTER TABLE belian.clinic_sales OWNER TO belian;

--
-- TOC entry 243 (class 1259 OID 28574)
-- Name: clinic_sales_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.clinic_sales_item (
    id text NOT NULL,
    fk_product_medicine text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_medication text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.clinic_sales_item OWNER TO belian;

--
-- TOC entry 244 (class 1259 OID 28586)
-- Name: company_structure; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.company_structure (
    id text NOT NULL,
    date_from date,
    date_to date,
    fk_organization text,
    company_structure_type text,
    fk_company_structure_parent text,
    version bigint DEFAULT 0,
    type text DEFAULT 'COMPANY'::text
);


ALTER TABLE belian.company_structure OWNER TO belian;

--
-- TOC entry 245 (class 1259 OID 28594)
-- Name: contact; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.contact (
    id text NOT NULL,
    contact text,
    contact_type text DEFAULT 'PHONE'::text,
    status character(1) DEFAULT '1'::bpchar,
    fk_party text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.contact OWNER TO belian;

--
-- TOC entry 246 (class 1259 OID 28604)
-- Name: container; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.container (
    id text NOT NULL,
    name text,
    note text,
    container_type text,
    parent text,
    fk_facility text,
    version bigint
);


ALTER TABLE belian.container OWNER TO belian;

--
-- TOC entry 247 (class 1259 OID 28611)
-- Name: country; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.country (
    id text NOT NULL,
    code text,
    name text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.country OWNER TO belian;

--
-- TOC entry 248 (class 1259 OID 28619)
-- Name: course_attendance; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_attendance (
    id text NOT NULL,
    course_attendance_date date,
    fk_schedule text,
    fk_staff text,
    fk_organization text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_attendance OWNER TO belian;

--
-- TOC entry 249 (class 1259 OID 28627)
-- Name: course_attendance_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_attendance_item (
    id text NOT NULL,
    fk_person text,
    status text DEFAULT 'LEAVE'::text,
    fk_attendance text,
    fk_time_entry text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_attendance_item OWNER TO belian;

--
-- TOC entry 250 (class 1259 OID 28636)
-- Name: course_discount; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_discount (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_discount text,
    fk_registration text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_discount OWNER TO belian;

--
-- TOC entry 251 (class 1259 OID 28645)
-- Name: course_installment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_installment (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    name text,
    fk_course_registration text
);


ALTER TABLE belian.course_installment OWNER TO belian;

--
-- TOC entry 252 (class 1259 OID 28653)
-- Name: course_installment_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_installment_item (
    id text NOT NULL,
    course_installment_item_resource text,
    quantity numeric(10,0) DEFAULT 1,
    uom text,
    unit_price numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_course_installment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_installment_item OWNER TO belian;

--
-- TOC entry 253 (class 1259 OID 28663)
-- Name: course_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    fk_product text,
    fk_product_feature text,
    fk_course_registration text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_item OWNER TO belian;

--
-- TOC entry 254 (class 1259 OID 28673)
-- Name: course_registration; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_registration (
    id text NOT NULL,
    fk_study_day text,
    fk_study_time text,
    fk_study_period text,
    course_registration_date date,
    course_registration_number text,
    fk_currency text,
    fk_organization text,
    fk_staff text,
    fk_student text,
    fk_tax text,
    fk_room text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.course_registration OWNER TO belian;

--
-- TOC entry 255 (class 1259 OID 28681)
-- Name: course_schedule; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.course_schedule (
    id text NOT NULL,
    course_schedule_day text,
    fk_room text,
    fk_product text
);


ALTER TABLE belian.course_schedule OWNER TO belian;

--
-- TOC entry 256 (class 1259 OID 28688)
-- Name: currency; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.currency (
    id text NOT NULL,
    code text,
    name text,
    is_default character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.currency OWNER TO belian;

--
-- TOC entry 257 (class 1259 OID 28697)
-- Name: currency_exchange_factor; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.currency_exchange_factor (
    id text NOT NULL,
    currency_exchange_factor_start date,
    currency_exchange_factor_end_date date,
    fk_currency_from text,
    fk_currency_to text,
    currency_exchange_factor_value numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.currency_exchange_factor OWNER TO belian;

--
-- TOC entry 258 (class 1259 OID 28706)
-- Name: deduction; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.deduction (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_doduction_type text,
    fk_paycheck text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.deduction OWNER TO belian;

--
-- TOC entry 259 (class 1259 OID 28715)
-- Name: deduction_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.deduction_type (
    id text NOT NULL,
    name text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.deduction_type OWNER TO belian;

--
-- TOC entry 260 (class 1259 OID 28723)
-- Name: deliverable; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.deliverable (
    id text NOT NULL,
    name text,
    note text,
    deliverable_type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.deliverable OWNER TO belian;

--
-- TOC entry 261 (class 1259 OID 28731)
-- Name: disbursement; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.disbursement (
    id text NOT NULL
);


ALTER TABLE belian.disbursement OWNER TO belian;

--
-- TOC entry 262 (class 1259 OID 28738)
-- Name: discount; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.discount (
    id text NOT NULL,
    discount_start date,
    discount_end_date date,
    name text,
    discount_value numeric(10,0) DEFAULT NULL::numeric,
    is_percent character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.discount OWNER TO belian;

--
-- TOC entry 263 (class 1259 OID 28748)
-- Name: doctor; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.doctor (
    id text NOT NULL,
    fk_doctor_type text
);


ALTER TABLE belian.doctor OWNER TO belian;

--
-- TOC entry 264 (class 1259 OID 28755)
-- Name: doctor_appointment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.doctor_appointment (
    id text NOT NULL,
    doctor_appointment_date date,
    fk_organization text,
    note text,
    version bigint,
    queue integer,
    fk_doctor text,
    fk_patient text,
    status text,
    fk_medical_record text
);


ALTER TABLE belian.doctor_appointment OWNER TO belian;

--
-- TOC entry 265 (class 1259 OID 28762)
-- Name: doctor_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.doctor_relationship (
    id text NOT NULL,
    fk_doctor_type text,
    fk_doctor text,
    fk_internal_organization text
);


ALTER TABLE belian.doctor_relationship OWNER TO belian;

--
-- TOC entry 266 (class 1259 OID 28769)
-- Name: doctor_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.doctor_type (
    id text NOT NULL,
    code text,
    name text,
    description text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.doctor_type OWNER TO belian;

--
-- TOC entry 267 (class 1259 OID 28777)
-- Name: employee; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.employee (
    id text NOT NULL,
    username text
);


ALTER TABLE belian.employee OWNER TO belian;

--
-- TOC entry 268 (class 1259 OID 28784)
-- Name: employer; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.employer (
    id text NOT NULL
);


ALTER TABLE belian.employer OWNER TO belian;

--
-- TOC entry 269 (class 1259 OID 29882)
-- Name: employment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.employment (
    id text NOT NULL
);


ALTER TABLE belian.employment OWNER TO belian;

--
-- TOC entry 270 (class 1259 OID 29889)
-- Name: employment_application; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.employment_application (
    id text NOT NULL,
    employment_application_date date,
    status_type text,
    source_type text,
    fk_position text,
    fk_person_referal text,
    fk_person_applicant text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.employment_application OWNER TO belian;

--
-- TOC entry 271 (class 1259 OID 29897)
-- Name: erp_mode; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.erp_mode (
    id text NOT NULL,
    segmentation text DEFAULT 'GENERAL'::text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.erp_mode OWNER TO belian;

--
-- TOC entry 272 (class 1259 OID 29906)
-- Name: facility; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.facility (
    id text NOT NULL,
    code text,
    name text,
    note text,
    facility_type text,
    fk_facility_parent text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.facility OWNER TO belian;

--
-- TOC entry 273 (class 1259 OID 29914)
-- Name: facility_organization; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.facility_organization (
    id text NOT NULL,
    enabled character(1) DEFAULT NULL::bpchar,
    fk_facility text,
    organization_id text,
    organization_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.facility_organization OWNER TO belian;

--
-- TOC entry 274 (class 1259 OID 29923)
-- Name: family_folder; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.family_folder (
    id text NOT NULL,
    name text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.family_folder OWNER TO belian;

--
-- TOC entry 275 (class 1259 OID 29931)
-- Name: family_member; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.family_member (
    id text NOT NULL,
    fk_patient text,
    member_type text DEFAULT 'HEAD'::text,
    fk_folder text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.family_member OWNER TO belian;

--
-- TOC entry 276 (class 1259 OID 29940)
-- Name: financial_account; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.financial_account (
    id text NOT NULL,
    name text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.financial_account OWNER TO belian;

--
-- TOC entry 277 (class 1259 OID 29948)
-- Name: financial_account_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.financial_account_role (
    id text NOT NULL,
    fk_party text,
    type text,
    fk_account text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.financial_account_role OWNER TO belian;

--
-- TOC entry 278 (class 1259 OID 29956)
-- Name: financial_account_transaction; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.financial_account_transaction (
    id text NOT NULL,
    transaction_date date,
    entry_date date,
    fk_payment text,
    fk_account text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.financial_account_transaction OWNER TO belian;

--
-- TOC entry 279 (class 1259 OID 29964)
-- Name: geographic; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.geographic (
    id text NOT NULL,
    code text,
    name text,
    type text DEFAULT 'COUNTRY'::text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.geographic OWNER TO belian;

--
-- TOC entry 280 (class 1259 OID 29973)
-- Name: gl_account; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.gl_account (
    id text NOT NULL,
    number text,
    name text,
    note text,
    type text,
    fk_gl_account_parent text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.gl_account OWNER TO belian;

--
-- TOC entry 281 (class 1259 OID 29981)
-- Name: gl_account_balance; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.gl_account_balance (
    id text NOT NULL,
    fk_accounting_period text,
    fk_gl_account text,
    fk_currency text,
    debet_balance numeric(10,0) DEFAULT NULL::numeric,
    credit_balance numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.gl_account_balance OWNER TO belian;

--
-- TOC entry 282 (class 1259 OID 29991)
-- Name: goods_issue; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.goods_issue (
    id text NOT NULL,
    issue_date date,
    fk_organization text,
    fk_facility_source text,
    fk_transfer_request text,
    fk_person_issued_by text,
    version text DEFAULT '0'::text
);


ALTER TABLE belian.goods_issue OWNER TO belian;

--
-- TOC entry 283 (class 1259 OID 29999)
-- Name: goods_issue_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.goods_issue_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_request_item text,
    fk_transfer_order text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.goods_issue_item OWNER TO belian;

--
-- TOC entry 284 (class 1259 OID 30008)
-- Name: goods_transfer; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.goods_transfer (
    id text NOT NULL,
    date date,
    number text,
    fk_organization_source text,
    fk_organization_destination text,
    fk_facility_from text,
    fk_facility_to text,
    fk_transfer_order_request text,
    fk_person_transfered_by text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.goods_transfer OWNER TO belian;

--
-- TOC entry 285 (class 1259 OID 30016)
-- Name: goods_transfer_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.goods_transfer_item (
    id text NOT NULL,
    fk_product text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_transfer_order_request_item text,
    fk_goods_transfer text,
    version bigint
);


ALTER TABLE belian.goods_transfer_item OWNER TO belian;

--
-- TOC entry 286 (class 1259 OID 30024)
-- Name: healtcare_practitioner; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.healtcare_practitioner (
    id text NOT NULL
);


ALTER TABLE belian.healtcare_practitioner OWNER TO belian;

--
-- TOC entry 287 (class 1259 OID 30031)
-- Name: healthcare_provider; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.healthcare_provider (
    id text NOT NULL,
    code text NOT NULL,
    name text NOT NULL,
    note text NOT NULL,
    version bigint NOT NULL
);


ALTER TABLE belian.healthcare_provider OWNER TO belian;

--
-- TOC entry 288 (class 1259 OID 30038)
-- Name: inbox; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.inbox (
    id text NOT NULL,
    date date,
    is_open character(1) DEFAULT '0'::bpchar,
    title text,
    fk_sender text,
    fk_receiver text,
    content text,
    type text DEFAULT 'Standard'::text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.inbox OWNER TO belian;

--
-- TOC entry 289 (class 1259 OID 30048)
-- Name: internal_organization; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.internal_organization (
    id text NOT NULL
);


ALTER TABLE belian.internal_organization OWNER TO belian;

--
-- TOC entry 290 (class 1259 OID 30055)
-- Name: inventory_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.inventory_item (
    id text NOT NULL,
    serial_number text,
    product_id text,
    product_value text,
    on_hand numeric(10,0) DEFAULT NULL::numeric,
    facility_id text,
    facility_value text,
    expired_date date,
    container_id text,
    container_value text,
    organization_id text,
    organization_value text,
    creator text,
    editor text,
    created timestamp without time zone,
    last_edited timestamp without time zone,
    on_order numeric(10,0) DEFAULT 0,
    control bigint,
    version bigint DEFAULT 0
);


ALTER TABLE belian.inventory_item OWNER TO belian;

--
-- TOC entry 291 (class 1259 OID 30474)
-- Name: invoice; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice (
    id text NOT NULL,
    number text,
    invoice_date date,
    note text,
    message text,
    billed_from_party_id text,
    billed_from_party_value text,
    billed_to_party_id text,
    billed_to_party_value text,
    billed_from_address_id text,
    billed_from_address_value text,
    billed_to_address_id text,
    billed_to_address_value text DEFAULT '0'::text,
    billed_from_contact_id text,
    billed_from_contact_value text,
    billed_to_contact_id text,
    billed_to_contact_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice OWNER TO belian;

--
-- TOC entry 292 (class 1259 OID 30483)
-- Name: invoice_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    amount numeric(10,0) DEFAULT NULL::numeric,
    taxable character(1) DEFAULT '0'::bpchar,
    type text,
    product_id text,
    product_value text,
    feature_id text,
    feature_value text,
    fk_sold_with text,
    fk_invoice text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_item OWNER TO belian;

--
-- TOC entry 293 (class 1259 OID 30494)
-- Name: invoice_order_item_billing; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_order_item_billing (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    amount numeric(10,0) DEFAULT NULL::numeric,
    order_item_id text,
    order_item_value text,
    order_id text,
    order_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_order_item_billing OWNER TO belian;

--
-- TOC entry 294 (class 1259 OID 30504)
-- Name: invoice_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_role (
    id text NOT NULL,
    inv_role_date timestamp without time zone,
    type text,
    party_id text,
    party_value text,
    fk_invoice text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_role OWNER TO belian;

--
-- TOC entry 295 (class 1259 OID 30512)
-- Name: invoice_shipment_item_billing; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_shipment_item_billing (
    id text NOT NULL,
    shipment_item_id text,
    shipment_item_value text,
    fk_invoice_item text,
    shipment_id text,
    shipment_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_shipment_item_billing OWNER TO belian;

--
-- TOC entry 296 (class 1259 OID 30520)
-- Name: invoice_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_status (
    id text NOT NULL,
    inv_status_date timestamp without time zone,
    type text,
    fk_invoice text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_status OWNER TO belian;

--
-- TOC entry 297 (class 1259 OID 30528)
-- Name: invoice_term; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_term (
    id text NOT NULL,
    value numeric(10,0) DEFAULT NULL::numeric,
    type text,
    fk_invoice text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_term OWNER TO belian;

--
-- TOC entry 298 (class 1259 OID 30537)
-- Name: invoice_time_entry_billing; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_time_entry_billing (
    id text NOT NULL,
    hour numeric(10,0) DEFAULT NULL::numeric,
    time_entry_id text,
    time_entry_value text DEFAULT '0'::text,
    fk_invoice_item text
);


ALTER TABLE belian.invoice_time_entry_billing OWNER TO belian;

--
-- TOC entry 299 (class 1259 OID 30546)
-- Name: invoice_work_effort_billing; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.invoice_work_effort_billing (
    id text NOT NULL,
    percent numeric(10,0) DEFAULT NULL::numeric,
    work_effort_id text,
    work_effort_value text,
    fk_invoice_item text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.invoice_work_effort_billing OWNER TO belian;

--
-- TOC entry 300 (class 1259 OID 30555)
-- Name: journal_entry; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.journal_entry (
    id text NOT NULL,
    entry_date date,
    total_debet numeric(10,0) DEFAULT NULL::numeric,
    total_credit text,
    fk_organization text,
    fk_organization_account text,
    fk_accounting_period text,
    fk_currency text,
    note text,
    is_posted character(1) DEFAULT '0'::bpchar,
    is_auto character(1) DEFAULT '0'::bpchar,
    version bigint
);


ALTER TABLE belian.journal_entry OWNER TO belian;

--
-- TOC entry 301 (class 1259 OID 30565)
-- Name: journal_entry_detail; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.journal_entry_detail (
    id text NOT NULL,
    fk_gl_account text,
    type text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_journal_entry text,
    note text,
    fk_journal_posting text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.journal_entry_detail OWNER TO belian;

--
-- TOC entry 302 (class 1259 OID 30574)
-- Name: journal_posting; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.journal_posting (
    id text NOT NULL,
    posting_date date,
    type text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_gl_account_balance text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.journal_posting OWNER TO belian;

--
-- TOC entry 303 (class 1259 OID 30583)
-- Name: journal_setting; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.journal_setting (
    id text NOT NULL,
    fk_organization text,
    fk_gl_account_cash text,
    fk_gl_account_sales text,
    fk_gl_account_ppn_payable text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.journal_setting OWNER TO belian;

--
-- TOC entry 304 (class 1259 OID 30591)
-- Name: laboratory; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.laboratory (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text,
    lab_handling_status text,
    is_personal character(1) DEFAULT '0'::bpchar
);


ALTER TABLE belian.laboratory OWNER TO belian;

--
-- TOC entry 305 (class 1259 OID 30600)
-- Name: laboratory_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.laboratory_item (
    id text NOT NULL,
    fk_product_service text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_laboratory text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.laboratory_item OWNER TO belian;

--
-- TOC entry 306 (class 1259 OID 30612)
-- Name: laboratory_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.laboratory_sales (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text,
    lab_handling_status text,
    is_personal character(1) DEFAULT '0'::bpchar
);


ALTER TABLE belian.laboratory_sales OWNER TO belian;

--
-- TOC entry 307 (class 1259 OID 30621)
-- Name: laboratory_sales_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.laboratory_sales_item (
    id text NOT NULL,
    fk_product_service text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_laboratory text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.laboratory_sales_item OWNER TO belian;

--
-- TOC entry 308 (class 1259 OID 30633)
-- Name: marital_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.marital_status (
    id text NOT NULL,
    start date,
    end_date date,
    type text DEFAULT 'SINGLE'::text,
    fk_person text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.marital_status OWNER TO belian;

--
-- TOC entry 309 (class 1259 OID 30642)
-- Name: medical_record; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medical_record (
    id text NOT NULL,
    record_date date,
    anamnesis text,
    checking_result text,
    diagnosis text,
    fk_patient text,
    fk_doctor text,
    fk_doctor_appointment text,
    fk_medication text,
    fk_treatment text,
    fk_laboratory text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.medical_record OWNER TO belian;

--
-- TOC entry 310 (class 1259 OID 30650)
-- Name: medical_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medical_sales (
    id text NOT NULL,
    queue integer,
    "time" time without time zone,
    status text DEFAULT 'Registered'::text
);


ALTER TABLE belian.medical_sales OWNER TO belian;

--
-- TOC entry 311 (class 1259 OID 30658)
-- Name: medical_treatment_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medical_treatment_sales (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text
);


ALTER TABLE belian.medical_treatment_sales OWNER TO belian;

--
-- TOC entry 312 (class 1259 OID 30666)
-- Name: medical_treatment_sales_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medical_treatment_sales_item (
    id text NOT NULL,
    fk_product_treatment text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    charge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_treatment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.medical_treatment_sales_item OWNER TO belian;

--
-- TOC entry 313 (class 1259 OID 30678)
-- Name: medication; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medication (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text,
    medication_status text
);


ALTER TABLE belian.medication OWNER TO belian;

--
-- TOC entry 314 (class 1259 OID 30686)
-- Name: medication_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.medication_item (
    id text NOT NULL,
    fk_product_medicine text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_medication text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.medication_item OWNER TO belian;

--
-- TOC entry 315 (class 1259 OID 30698)
-- Name: message; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.message (
    id text NOT NULL,
    message_date date,
    title text,
    fk_sender text,
    content text,
    type text DEFAULT 'Draft'::text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.message OWNER TO belian;

--
-- TOC entry 316 (class 1259 OID 30707)
-- Name: message_receiver; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.message_receiver (
    id text NOT NULL,
    fk_receiver text,
    fk_message text,
    version bigint
);


ALTER TABLE belian.message_receiver OWNER TO belian;

--
-- TOC entry 318 (class 1259 OID 30724)
-- Name: notification; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.notification (
    id text NOT NULL,
    new_message integer DEFAULT 0,
    version bigint
);


ALTER TABLE belian.notification OWNER TO belian;

--
-- TOC entry 319 (class 1259 OID 30732)
-- Name: order_adjustment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_adjustment (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    percent numeric(10,0) DEFAULT NULL::numeric,
    type text,
    fk_order text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_adjustment OWNER TO belian;

--
-- TOC entry 320 (class 1259 OID 30742)
-- Name: order_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    unit_price numeric(10,0) DEFAULT NULL::numeric,
    uom_id text,
    uom_value text,
    product_id text,
    product_value text,
    product_feature_id text,
    product_feature_value text,
    note text,
    fk_order text,
    type text DEFAULT 'PRODUCT'::text,
    is_shipped character(1) DEFAULT '0'::bpchar,
    processed numeric(10,0) DEFAULT 0,
    invoiced character(1) DEFAULT '0'::bpchar,
    requirement character(1) DEFAULT '0'::bpchar,
    workeffort character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_item OWNER TO belian;

--
-- TOC entry 321 (class 1259 OID 30758)
-- Name: order_item_assosiation; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_item_assosiation (
    id text NOT NULL,
    sales_item text,
    purchase_item text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_item_assosiation OWNER TO belian;

--
-- TOC entry 322 (class 1259 OID 30766)
-- Name: order_payment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_payment (
    id text NOT NULL,
    fk_purchase_order text,
    fk_payment_item text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_payment OWNER TO belian;

--
-- TOC entry 323 (class 1259 OID 30774)
-- Name: order_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_role (
    id text NOT NULL,
    person_id text,
    person_value text,
    type text,
    fk_order text,
    percent_contribution numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_role OWNER TO belian;

--
-- TOC entry 324 (class 1259 OID 30783)
-- Name: order_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_status (
    id text NOT NULL,
    status_date timestamp without time zone,
    fk_order text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_status OWNER TO belian;

--
-- TOC entry 325 (class 1259 OID 30791)
-- Name: order_term; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_term (
    id text NOT NULL,
    fk_order text,
    order_item text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    term_id text,
    term_value text,
    version bigint
);


ALTER TABLE belian.order_term OWNER TO belian;

--
-- TOC entry 326 (class 1259 OID 30799)
-- Name: order_value; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.order_value (
    id text NOT NULL,
    min numeric(10,0) DEFAULT NULL::numeric,
    max numeric(10,0) DEFAULT NULL::numeric,
    value bigint DEFAULT 0,
    version bigint DEFAULT 0
);


ALTER TABLE belian.order_value OWNER TO belian;

--
-- TOC entry 327 (class 1259 OID 30810)
-- Name: orders; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.orders (
    id text NOT NULL,
    document_number text,
    order_date date,
    entry_date date,
    billing_address_id text,
    billing_address_value text,
    shipping_address_id text,
    shipping_address_value text,
    placing_order_id text,
    placing_order_value text,
    taking_order_id text,
    taking_order_value text,
    ship_to_party_id text,
    ship_to_party_value text,
    bill_to_id text,
    bill_to_value text,
    ship_to_contact_id text,
    ship_to_contact_value text,
    bill_to_contact_id text,
    bill_to_contact_value text,
    bill_to_party_id text,
    bill_to_party_value text,
    currency_id text,
    currency_value text,
    transaction_type text DEFAULT 'STANDARD'::text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.orders OWNER TO belian;

--
-- TOC entry 328 (class 1259 OID 30819)
-- Name: organization_account; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.organization_account (
    id text NOT NULL,
    name text,
    note text,
    status character(1) DEFAULT '0'::bpchar,
    fk_organization text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.organization_account OWNER TO belian;

--
-- TOC entry 329 (class 1259 OID 30828)
-- Name: organization_gl_account; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.organization_gl_account (
    id text NOT NULL,
    is_selected character(1) DEFAULT '0'::bpchar,
    fk_account text,
    fk_organization_account text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.organization_gl_account OWNER TO belian;

--
-- TOC entry 330 (class 1259 OID 30837)
-- Name: organization_period; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.organization_period (
    id text NOT NULL,
    fk_organization text,
    fk_accounting_period text,
    is_closed character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.organization_period OWNER TO belian;

--
-- TOC entry 331 (class 1259 OID 30846)
-- Name: party; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party (
    id text NOT NULL,
    name text,
    fk_geographic_birth_place text,
    birth_date date,
    tax_code text,
    code text,
    version bigint DEFAULT 0,
    is_system integer DEFAULT 0,
    gender text,
    type text NOT NULL
);


ALTER TABLE belian.party OWNER TO belian;

--
-- TOC entry 332 (class 1259 OID 30855)
-- Name: party_classification; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_classification (
    id text NOT NULL,
    start date,
    end_date date,
    type text,
    value text,
    fk_party text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.party_classification OWNER TO belian;

--
-- TOC entry 333 (class 1259 OID 30863)
-- Name: party_rate; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_rate (
    id text NOT NULL,
    start date,
    end_date date,
    rate numeric(10,0) DEFAULT NULL::numeric,
    type text,
    fk_party text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.party_rate OWNER TO belian;

--
-- TOC entry 334 (class 1259 OID 30872)
-- Name: party_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_relationship (
    id text NOT NULL,
    start date,
    end_date date,
    fk_from_role text,
    fk_to_role text,
    fk_from_party text,
    fk_to_party text,
    type text,
    version bigint,
    status text DEFAULT 'ACTIVE'::text
);


ALTER TABLE belian.party_relationship OWNER TO belian;

--
-- TOC entry 335 (class 1259 OID 30880)
-- Name: party_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_role (
    id text NOT NULL,
    start date,
    end_date date,
    fk_party text,
    type text,
    version bigint
);


ALTER TABLE belian.party_role OWNER TO belian;

--
-- TOC entry 336 (class 1259 OID 30887)
-- Name: party_skill; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_skill (
    id text NOT NULL,
    fk_party text,
    fk_type text,
    start date,
    end_date date,
    version bigint DEFAULT 0
);


ALTER TABLE belian.party_skill OWNER TO belian;

--
-- TOC entry 337 (class 1259 OID 30895)
-- Name: party_skill_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.party_skill_type (
    id text NOT NULL,
    name text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.party_skill_type OWNER TO belian;

--
-- TOC entry 338 (class 1259 OID 30903)
-- Name: passport; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.passport (
    id text NOT NULL,
    number text,
    issued_date date,
    expiration_date date,
    fk_country text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.passport OWNER TO belian;

--
-- TOC entry 339 (class 1259 OID 30911)
-- Name: patient; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.patient (
    id text NOT NULL,
    fk_bpjs text
);


ALTER TABLE belian.patient OWNER TO belian;

--
-- TOC entry 340 (class 1259 OID 30918)
-- Name: patient_practitioner_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.patient_practitioner_relationship (
    id text NOT NULL
);


ALTER TABLE belian.patient_practitioner_relationship OWNER TO belian;

--
-- TOC entry 341 (class 1259 OID 30925)
-- Name: patient_provider_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.patient_provider_relationship (
    id text NOT NULL
);


ALTER TABLE belian.patient_provider_relationship OWNER TO belian;

--
-- TOC entry 342 (class 1259 OID 30932)
-- Name: patient_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.patient_relationship (
    id text NOT NULL,
    fk_patient text,
    fk_internal_organization text
);


ALTER TABLE belian.patient_relationship OWNER TO belian;

--
-- TOC entry 343 (class 1259 OID 30939)
-- Name: pay_history; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pay_history (
    id text NOT NULL,
    start date,
    end_date date,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_uom text,
    fk_employment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.pay_history OWNER TO belian;

--
-- TOC entry 344 (class 1259 OID 30948)
-- Name: payable; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payable (
    id text NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE belian.payable OWNER TO belian;

--
-- TOC entry 345 (class 1259 OID 30956)
-- Name: paycheck; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.paycheck (
    id text NOT NULL,
    fk_empployment text,
    start date,
    end_date date
);


ALTER TABLE belian.paycheck OWNER TO belian;

--
-- TOC entry 346 (class 1259 OID 30963)
-- Name: paycheck_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.paycheck_item (
    id text NOT NULL,
    method text,
    account text,
    bank text,
    fk_paycheck text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.paycheck_item OWNER TO belian;

--
-- TOC entry 347 (class 1259 OID 30972)
-- Name: payment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payment (
    id text NOT NULL,
    reference text,
    payment_date date,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_staff text,
    note text,
    fk_organization text,
    fk_currency text,
    fk_tax text,
    fk_payment_type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.payment OWNER TO belian;

--
-- TOC entry 348 (class 1259 OID 30981)
-- Name: payment_application; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payment_application (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_billing text,
    fk_receipt text,
    version bigint
);


ALTER TABLE belian.payment_application OWNER TO belian;

--
-- TOC entry 349 (class 1259 OID 30989)
-- Name: payment_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payment_item (
    id text NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE belian.payment_item OWNER TO belian;

--
-- TOC entry 350 (class 1259 OID 30997)
-- Name: payment_method_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payment_method_type (
    id text NOT NULL,
    name text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.payment_method_type OWNER TO belian;

--
-- TOC entry 351 (class 1259 OID 31005)
-- Name: payroll_preference; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.payroll_preference (
    id text NOT NULL,
    start date,
    end_date date,
    fk_payment_method_type text,
    percent numeric(10,0) DEFAULT NULL::numeric,
    amount numeric(10,0) DEFAULT NULL::numeric,
    bank_number text,
    bank_name text,
    period_type text,
    fk_employee text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.payroll_preference OWNER TO belian;

--
-- TOC entry 352 (class 1259 OID 31015)
-- Name: pharmacy_sales; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pharmacy_sales (
    id text NOT NULL,
    is_reference character(1) DEFAULT '0'::bpchar
);


ALTER TABLE belian.pharmacy_sales OWNER TO belian;

--
-- TOC entry 353 (class 1259 OID 31023)
-- Name: pharmacy_sales_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pharmacy_sales_item (
    id text NOT NULL,
    fk_product text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    fk_pharmacy_sales text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.pharmacy_sales_item OWNER TO belian;

--
-- TOC entry 354 (class 1259 OID 31035)
-- Name: physical_characteristic; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.physical_characteristic (
    id text NOT NULL,
    start date,
    end_date date,
    type text,
    value text,
    fk_person text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.physical_characteristic OWNER TO belian;

--
-- TOC entry 355 (class 1259 OID 31043)
-- Name: pick_list; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pick_list (
    id text NOT NULL,
    pick_list_date date,
    version bigint DEFAULT 0
);


ALTER TABLE belian.pick_list OWNER TO belian;

--
-- TOC entry 356 (class 1259 OID 31051)
-- Name: pick_list_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pick_list_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT 1,
    fk_inventory_item text,
    fk_pick_list text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.pick_list_item OWNER TO belian;

--
-- TOC entry 357 (class 1259 OID 31060)
-- Name: pos_sales_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.pos_sales_order (
    id text NOT NULL
);


ALTER TABLE belian.pos_sales_order OWNER TO belian;

--
-- TOC entry 358 (class 1259 OID 31067)
-- Name: position; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian."position" (
    id text NOT NULL,
    start date,
    end_date date,
    actual_start_date date,
    actual_end_date date,
    worktime_status text,
    temporary_status text,
    salary_status text,
    position_status_type text,
    fk_budget_item text,
    fk_position_type text,
    fk_organization_owner text,
    version bigint DEFAULT 0
);


ALTER TABLE belian."position" OWNER TO belian;

--
-- TOC entry 359 (class 1259 OID 31075)
-- Name: position_fulfillment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.position_fulfillment (
    id text NOT NULL,
    start date,
    end_date date,
    note text,
    fk_person_employee text,
    fk_position text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.position_fulfillment OWNER TO belian;

--
-- TOC entry 360 (class 1259 OID 31083)
-- Name: position_reporting_structure; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.position_reporting_structure (
    id text NOT NULL,
    start date,
    end_date date,
    note text,
    is_primary character(1) DEFAULT '0'::bpchar,
    fk_position_reporting_to text,
    fk_position_parent text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.position_reporting_structure OWNER TO belian;

--
-- TOC entry 361 (class 1259 OID 31092)
-- Name: position_responsibility; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.position_responsibility (
    id text NOT NULL,
    start date,
    end_date date,
    note text,
    fk_position text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.position_responsibility OWNER TO belian;

--
-- TOC entry 362 (class 1259 OID 31100)
-- Name: position_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.position_type (
    id text NOT NULL,
    title text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.position_type OWNER TO belian;

--
-- TOC entry 363 (class 1259 OID 31108)
-- Name: position_type_rate; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.position_type_rate (
    id text NOT NULL,
    start date,
    end_date date,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_currency text,
    fk_position_type text,
    rate_type text,
    period_type text,
    comment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.position_type_rate OWNER TO belian;

--
-- TOC entry 364 (class 1259 OID 31117)
-- Name: practitioner_provider_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.practitioner_provider_relationship (
    id text NOT NULL
);


ALTER TABLE belian.practitioner_provider_relationship OWNER TO belian;

--
-- TOC entry 365 (class 1259 OID 31124)
-- Name: price_component; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.price_component (
    id text NOT NULL,
    start date,
    end_date date,
    price numeric(10,0) DEFAULT NULL::numeric,
    percent numeric(10,0) DEFAULT 0,
    currency_id text,
    currency_value text,
    type text,
    area_id text,
    area_value text,
    category_id text,
    category_value text,
    fk_quantity_break text,
    fk_order_value text,
    sales_type text,
    party_id text,
    party_value text,
    fk_product text,
    feature_id text,
    feature_value text,
    version bigint
);


ALTER TABLE belian.price_component OWNER TO belian;

--
-- TOC entry 366 (class 1259 OID 31133)
-- Name: product; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product (
    id text NOT NULL,
    name text,
    introduction_date date,
    discontinuation_date date,
    support_discontinuation_date date,
    comment text,
    uom_id text,
    uom_value text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product OWNER TO belian;

--
-- TOC entry 367 (class 1259 OID 31141)
-- Name: product_category; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_category (
    id text NOT NULL,
    name text,
    note text,
    fk_parent text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_category OWNER TO belian;

--
-- TOC entry 368 (class 1259 OID 31149)
-- Name: product_category_classification; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_category_classification (
    id text NOT NULL,
    start date,
    end_date date,
    category_id text,
    category_value text,
    fk_product text,
    is_primary character(1) DEFAULT '0'::bpchar,
    comment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_category_classification OWNER TO belian;

--
-- TOC entry 369 (class 1259 OID 31158)
-- Name: product_code; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_code (
    id text NOT NULL,
    code text,
    type text,
    note text,
    fk_product text,
    version bigint
);


ALTER TABLE belian.product_code OWNER TO belian;

--
-- TOC entry 370 (class 1259 OID 31165)
-- Name: product_component; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_component (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    product_id text,
    fk_product_parent text,
    product_value text,
    note text,
    start date,
    end_date date,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_component OWNER TO belian;

--
-- TOC entry 371 (class 1259 OID 31174)
-- Name: product_cost; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_cost (
    id text NOT NULL,
    start date,
    end_date date,
    estimated numeric(10,0) DEFAULT NULL::numeric,
    type text,
    fk_product text,
    currency_id text,
    currency_value text,
    geographic_id text,
    geographic_value text,
    feature_id text,
    feature_value text,
    party_id text,
    party_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_cost OWNER TO belian;

--
-- TOC entry 372 (class 1259 OID 31183)
-- Name: product_feature; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_feature (
    id text NOT NULL,
    value text,
    type text,
    note text,
    fk_product text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_feature OWNER TO belian;

--
-- TOC entry 373 (class 1259 OID 31191)
-- Name: product_feature_applicability; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_feature_applicability (
    id text NOT NULL,
    start date,
    end_date date,
    category text,
    fk_product text,
    feature_id text,
    feature_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_feature_applicability OWNER TO belian;

--
-- TOC entry 374 (class 1259 OID 31199)
-- Name: product_identification; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_identification (
    id text NOT NULL,
    value text,
    type text,
    note text,
    fk_product text,
    version bigint
);


ALTER TABLE belian.product_identification OWNER TO belian;

--
-- TOC entry 375 (class 1259 OID 31206)
-- Name: product_price; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_price (
    id text NOT NULL,
    start date,
    end_date date,
    price numeric(10,0) DEFAULT NULL::numeric,
    fk_currency text,
    type text,
    fk_geographic text,
    fk_party text,
    fk_product text,
    fk_product_feature text,
    is_percent character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_price OWNER TO belian;

--
-- TOC entry 376 (class 1259 OID 31216)
-- Name: product_receivable; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_receivable (
    id text NOT NULL,
    receivable_date date,
    number text,
    fk_organization text,
    status text,
    version bigint
);


ALTER TABLE belian.product_receivable OWNER TO belian;

--
-- TOC entry 377 (class 1259 OID 31223)
-- Name: product_requirement; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_requirement (
    id text NOT NULL,
    product_id text NOT NULL,
    product_value text,
    feature_id text,
    feature_value text,
    quantity numeric(10,0) DEFAULT 1
);


ALTER TABLE belian.product_requirement OWNER TO belian;

--
-- TOC entry 378 (class 1259 OID 31231)
-- Name: product_retur; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_retur (
    id text NOT NULL,
    retur_date date,
    fk_supplier text,
    fk_organization text,
    fk_facility text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_retur OWNER TO belian;

--
-- TOC entry 379 (class 1259 OID 31239)
-- Name: product_retur_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_retur_item (
    id text NOT NULL,
    fk_product text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    expired_date date,
    fk_product_retur text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_retur_item OWNER TO belian;

--
-- TOC entry 380 (class 1259 OID 31248)
-- Name: product_supplier; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.product_supplier (
    id text NOT NULL,
    start date,
    end_date date,
    supplier_id text,
    supplier_value text,
    fk_product text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.product_supplier OWNER TO belian;

--
-- TOC entry 381 (class 1259 OID 31256)
-- Name: production_info; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.production_info (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    product_id text,
    product_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.production_info OWNER TO belian;

--
-- TOC entry 382 (class 1259 OID 31265)
-- Name: production_run_properties; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.production_run_properties (
    id text NOT NULL,
    required_quantity text,
    produced_quantity text,
    rejected_quantity text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.production_run_properties OWNER TO belian;

--
-- TOC entry 383 (class 1259 OID 31273)
-- Name: purchase_invoice; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_invoice (
    id text NOT NULL
);


ALTER TABLE belian.purchase_invoice OWNER TO belian;

--
-- TOC entry 384 (class 1259 OID 31280)
-- Name: purchase_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order (
    id text NOT NULL
);


ALTER TABLE belian.purchase_order OWNER TO belian;

--
-- TOC entry 385 (class 1259 OID 31287)
-- Name: purchase_order_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_item (
    id text NOT NULL,
    fk_product text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_purchase_order_request_item text,
    expired_date date,
    version bigint DEFAULT 0
);


ALTER TABLE belian.purchase_order_item OWNER TO belian;

--
-- TOC entry 386 (class 1259 OID 31296)
-- Name: purchase_order_request; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_request (
    id text NOT NULL,
    request_date date
);


ALTER TABLE belian.purchase_order_request OWNER TO belian;

--
-- TOC entry 387 (class 1259 OID 31303)
-- Name: purchase_order_request_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_request_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_purchase_order_request text,
    fk_product text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.purchase_order_request_item OWNER TO belian;

--
-- TOC entry 388 (class 1259 OID 31312)
-- Name: purchase_order_request_review; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_request_review (
    id text NOT NULL,
    fk_purchase_order_request text
);


ALTER TABLE belian.purchase_order_request_review OWNER TO belian;

--
-- TOC entry 389 (class 1259 OID 31319)
-- Name: purchase_order_request_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_request_role (
    id text NOT NULL,
    fk_purchase_order_request text
);


ALTER TABLE belian.purchase_order_request_role OWNER TO belian;

--
-- TOC entry 390 (class 1259 OID 31326)
-- Name: purchase_order_request_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.purchase_order_request_status (
    id text NOT NULL,
    fk_purchase_order_request text
);


ALTER TABLE belian.purchase_order_request_status OWNER TO belian;

--
-- TOC entry 391 (class 1259 OID 31333)
-- Name: quantity_break; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quantity_break (
    id text NOT NULL,
    min numeric(10,0) DEFAULT NULL::numeric,
    max numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quantity_break OWNER TO belian;

--
-- TOC entry 392 (class 1259 OID 31343)
-- Name: quick_launch; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quick_launch (
    id text NOT NULL,
    name text,
    username text,
    fisheye_enabled character(1) DEFAULT '0'::bpchar,
    menu_enabled character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quick_launch OWNER TO belian;

--
-- TOC entry 393 (class 1259 OID 31353)
-- Name: quote; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quote (
    id text NOT NULL,
    issue_date date,
    valid_from date,
    valid_to date,
    type text,
    description text,
    fk_issuer text,
    fk_receiver text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quote OWNER TO belian;

--
-- TOC entry 394 (class 1259 OID 31361)
-- Name: quote_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quote_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    unit_price numeric(10,0) DEFAULT NULL::numeric,
    delivery_date date,
    fk_uom text,
    comment text,
    fk_request_item text,
    fk_quote text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quote_item OWNER TO belian;

--
-- TOC entry 395 (class 1259 OID 31371)
-- Name: quote_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quote_role (
    id text NOT NULL,
    fk_person text,
    fk_quote text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quote_role OWNER TO belian;

--
-- TOC entry 396 (class 1259 OID 31379)
-- Name: quote_term; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.quote_term (
    id text NOT NULL,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_quote text,
    fk_quote_item text,
    fk_term_type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.quote_term OWNER TO belian;

--
-- TOC entry 397 (class 1259 OID 31388)
-- Name: receipt; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.receipt (
    id text NOT NULL
);


ALTER TABLE belian.receipt OWNER TO belian;

--
-- TOC entry 398 (class 1259 OID 31395)
-- Name: receivable_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.receivable_order (
    id text NOT NULL,
    received numeric(10,0) DEFAULT NULL::numeric
);


ALTER TABLE belian.receivable_order OWNER TO belian;

--
-- TOC entry 399 (class 1259 OID 31403)
-- Name: recurring_payment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.recurring_payment (
    id text NOT NULL,
    name text
);


ALTER TABLE belian.recurring_payment OWNER TO belian;

--
-- TOC entry 400 (class 1259 OID 31410)
-- Name: request; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.request (
    id text NOT NULL,
    entry_date date,
    required_date date,
    order_date date,
    description text,
    type text,
    originator_id text,
    originator_value text,
    responding_id text,
    responding_value text,
    is_closed text DEFAULT '0'::text,
    number text,
    version character(1) DEFAULT '0'::bpchar
);


ALTER TABLE belian.request OWNER TO belian;

--
-- TOC entry 401 (class 1259 OID 31419)
-- Name: request_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.request_item (
    id text NOT NULL,
    required_date date,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    max_allowable_price numeric(10,0) DEFAULT NULL::numeric,
    description text,
    fk_request text,
    product_id text,
    product_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.request_item OWNER TO belian;

--
-- TOC entry 402 (class 1259 OID 31429)
-- Name: request_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.request_role (
    id text NOT NULL,
    fk_request text
);


ALTER TABLE belian.request_role OWNER TO belian;

--
-- TOC entry 403 (class 1259 OID 31436)
-- Name: requirement; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.requirement (
    id text NOT NULL,
    number text,
    creation_date date,
    required_date date,
    description text,
    reason text,
    estimated_budget numeric(10,0) DEFAULT NULL::numeric,
    type text,
    organization_id text,
    organization_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.requirement OWNER TO belian;

--
-- TOC entry 404 (class 1259 OID 31445)
-- Name: requirement_order_commitment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.requirement_order_commitment (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_order_item text,
    requirement_id text,
    requirement_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.requirement_order_commitment OWNER TO belian;

--
-- TOC entry 405 (class 1259 OID 31454)
-- Name: requirement_request; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.requirement_request (
    id text NOT NULL,
    fk_request_item text,
    fk_requirement text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.requirement_request OWNER TO belian;

--
-- TOC entry 406 (class 1259 OID 31462)
-- Name: requirement_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.requirement_role (
    id text NOT NULL,
    start date,
    end_date date,
    type text,
    party_id text,
    party_value text,
    fk_requirement text,
    version bigint
);


ALTER TABLE belian.requirement_role OWNER TO belian;

--
-- TOC entry 407 (class 1259 OID 31469)
-- Name: requirement_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.requirement_status (
    id text NOT NULL,
    status_date date,
    type text,
    fk_requirement text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.requirement_status OWNER TO belian;

--
-- TOC entry 408 (class 1259 OID 31477)
-- Name: review; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.review (
    id text NOT NULL,
    fk_party text,
    result text,
    review_date date,
    version bigint DEFAULT 0
);


ALTER TABLE belian.review OWNER TO belian;

--
-- TOC entry 409 (class 1259 OID 31485)
-- Name: role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.role (
    id text NOT NULL,
    code text,
    name text,
    note text,
    version bigint,
    is_enabled character(1)
);


ALTER TABLE belian.role OWNER TO belian;

--
-- TOC entry 214 (class 1259 OID 28331)
-- Name: role_module; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.role_module (
    id text NOT NULL,
    fk_role text,
    fk_module text,
    module_code text,
    module_name text,
    is_can_read character(1) DEFAULT '0'::bpchar,
    is_can_update character(1) DEFAULT '0'::bpchar,
    is_can_delete character(1) DEFAULT '0'::bpchar,
    is_can_create character(1) DEFAULT '0'::bpchar,
    is_can_print character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0,
    is_enabled character(1)
);


ALTER TABLE belian.role_module OWNER TO belian;

--
-- TOC entry 410 (class 1259 OID 31492)
-- Name: roled; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.roled (
    id text NOT NULL,
    fk_party text,
    role_type text,
    is_done character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.roled OWNER TO belian;

--
-- TOC entry 411 (class 1259 OID 31501)
-- Name: sales_invoice; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.sales_invoice (
    id text NOT NULL
);


ALTER TABLE belian.sales_invoice OWNER TO belian;

--
-- TOC entry 412 (class 1259 OID 31508)
-- Name: sales_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.sales_order (
    id text NOT NULL
);


ALTER TABLE belian.sales_order OWNER TO belian;

--
-- TOC entry 413 (class 1259 OID 31515)
-- Name: sales_order_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.sales_order_item (
    id text NOT NULL
);


ALTER TABLE belian.sales_order_item OWNER TO belian;

--
-- TOC entry 414 (class 1259 OID 31522)
-- Name: sequence_number; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.sequence_number (
    id text NOT NULL,
    number_date date,
    person_id text,
    organization_id text,
    code text,
    sequence bigint DEFAULT 1,
    year integer,
    month integer,
    version bigint DEFAULT 0
);


ALTER TABLE belian.sequence_number OWNER TO belian;

--
-- TOC entry 415 (class 1259 OID 31531)
-- Name: shipment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment (
    id text NOT NULL,
    entry_date date,
    estimated_ship_date date,
    estimated_ready_date date,
    estimated_arrival_date date,
    allowable_cancel_date date,
    estimated_ship_cost numeric(10,0) DEFAULT NULL::numeric,
    act_ship_cost numeric(10,0) DEFAULT NULL::numeric,
    last_updated_date date,
    instruction text,
    type text,
    number text,
    ship_from_party_id text,
    ship_from_party_value text,
    ship_from_address_id text,
    ship_from_address_value text,
    ship_from_contact_id text,
    ship_from_contact_value text,
    ship_to_party_id text,
    ship_to_party_value text DEFAULT '0'::text,
    ship_to_address_id text,
    ship_to_address_value text,
    ship_to_contact_id text,
    ship_to_contact_value text,
    fk_shipping_document text,
    last_status text DEFAULT 'SCHEDULED'::text,
    version bigint
);


ALTER TABLE belian.shipment OWNER TO belian;

--
-- TOC entry 416 (class 1259 OID 31542)
-- Name: shipment_issuance; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_issuance (
    id text NOT NULL,
    number text,
    issuance_date date,
    organization_id text,
    organization_value text,
    destination_party_id text,
    destination_party_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_issuance OWNER TO belian;

--
-- TOC entry 417 (class 1259 OID 31550)
-- Name: shipment_issuance_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_issuance_item (
    id text NOT NULL,
    accepted numeric(10,0) DEFAULT NULL::numeric,
    rejected numeric(10,0) DEFAULT NULL::numeric,
    expired date,
    serial text,
    product_id text,
    product_value text,
    shipment_item_id text,
    shipment_item_value text,
    order_item_id text,
    order_item_value text,
    facility_id text,
    facility_value text,
    container_id text,
    container_value text,
    fk_shipment_issuance text,
    note text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_issuance_item OWNER TO belian;

--
-- TOC entry 418 (class 1259 OID 31560)
-- Name: shipment_issuance_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_issuance_role (
    id text NOT NULL,
    party_id text,
    party_value text,
    type text,
    fk_shipment_issuance text,
    version bigint
);


ALTER TABLE belian.shipment_issuance_role OWNER TO belian;

--
-- TOC entry 419 (class 1259 OID 31766)
-- Name: shipment_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    processed numeric(10,0) DEFAULT 0,
    content text,
    fk_shipment text,
    fk_shipping_document text,
    product_id text,
    product_value text,
    invoiced character(1) DEFAULT '0'::bpchar,
    version bigint
);


ALTER TABLE belian.shipment_item OWNER TO belian;

--
-- TOC entry 420 (class 1259 OID 31776)
-- Name: shipment_order; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_order (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    unit_price numeric(10,0) DEFAULT 0,
    order_item_id text,
    order_item_value text,
    order_id text,
    order_value text,
    fk_shipment_item text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_order OWNER TO belian;

--
-- TOC entry 421 (class 1259 OID 31786)
-- Name: shipment_receipt; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_receipt (
    id text NOT NULL,
    receipt_date date,
    number text,
    organization_id text,
    organization_value text,
    source_party_id text DEFAULT '0'::text,
    source_party_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_receipt OWNER TO belian;

--
-- TOC entry 422 (class 1259 OID 31795)
-- Name: shipment_receipt_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_receipt_item (
    id text NOT NULL,
    accepted numeric(10,0) DEFAULT NULL::numeric,
    rejected numeric(10,0) DEFAULT NULL::numeric,
    shipment_item_id text,
    shipment_item_value text DEFAULT '0'::text,
    facility_id text,
    facility_value text,
    container_id text,
    container_value text,
    fk_shipment_receipt text,
    note text,
    expired date,
    serial text,
    order_item_id text,
    order_item_value text,
    product_id text,
    product_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_receipt_item OWNER TO belian;

--
-- TOC entry 423 (class 1259 OID 31806)
-- Name: shipment_receipt_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_receipt_role (
    id text NOT NULL,
    party_id text,
    party_value text,
    type text,
    fk_shipment_receipt text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_receipt_role OWNER TO belian;

--
-- TOC entry 424 (class 1259 OID 31814)
-- Name: shipment_route_segment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_route_segment (
    id text NOT NULL,
    est_start_date date,
    est_arrival_date date,
    act_start_date date,
    act_arrival_date date,
    start_mileage numeric(10,0) DEFAULT NULL::numeric,
    end_mileage numeric(10,0) DEFAULT NULL::numeric,
    fuel_used numeric(10,0) DEFAULT NULL::numeric,
    type text,
    vehicle_id text,
    vehicle_value text,
    carrier_id text,
    carrier_value text,
    fk_shipment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_route_segment OWNER TO belian;

--
-- TOC entry 425 (class 1259 OID 31825)
-- Name: shipment_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipment_status (
    id text NOT NULL,
    status_date timestamp without time zone,
    type text,
    fk_shipment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipment_status OWNER TO belian;

--
-- TOC entry 426 (class 1259 OID 31833)
-- Name: shipping_document; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.shipping_document (
    id text NOT NULL,
    description text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.shipping_document OWNER TO belian;

--
-- TOC entry 427 (class 1259 OID 31841)
-- Name: simple_invoice_clinic; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.simple_invoice_clinic (
    id text NOT NULL,
    clinic_date date,
    fk_organization text,
    fk_customer text,
    fk_employe text,
    fk_currency text,
    note text,
    number text,
    is_paid character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.simple_invoice_clinic OWNER TO belian;

--
-- TOC entry 428 (class 1259 OID 31850)
-- Name: simple_invoice_clinic_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.simple_invoice_clinic_item (
    id text NOT NULL,
    note text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    fk_root text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.simple_invoice_clinic_item OWNER TO belian;

--
-- TOC entry 429 (class 1259 OID 31859)
-- Name: statuses; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.statuses (
    id text NOT NULL,
    statuses_date date,
    description text,
    type text,
    fk_party text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.statuses OWNER TO belian;

--
-- TOC entry 430 (class 1259 OID 31867)
-- Name: stock_adjustment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_adjustment (
    id text NOT NULL,
    adjustment_date date,
    "time" time without time zone,
    facility_id text,
    facility_value text,
    organization_id text,
    organization_value text,
    note text,
    creator text,
    editor text,
    created timestamp without time zone,
    last_edited timestamp without time zone,
    version bigint DEFAULT 0
);


ALTER TABLE belian.stock_adjustment OWNER TO belian;

--
-- TOC entry 431 (class 1259 OID 31875)
-- Name: stock_adjustment_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_adjustment_item (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_stock_adjustment text,
    product_id text,
    product_value text,
    note text,
    expired_date date,
    type text,
    container_value text,
    container_id text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.stock_adjustment_item OWNER TO belian;

--
-- TOC entry 432 (class 1259 OID 31884)
-- Name: stock_admin; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_admin (
    id text NOT NULL,
    fk_employee text,
    fk_internal_organization text
);


ALTER TABLE belian.stock_admin OWNER TO belian;

--
-- TOC entry 433 (class 1259 OID 31891)
-- Name: stock_history; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_history (
    id text NOT NULL,
    history_date date,
    stock_in numeric(10,0) DEFAULT NULL::numeric,
    stock_out numeric(10,0) DEFAULT NULL::numeric,
    fk_inventory_item text,
    creator text,
    editor text,
    created timestamp without time zone,
    last_edited timestamp without time zone,
    version bigint DEFAULT 0
);


ALTER TABLE belian.stock_history OWNER TO belian;

--
-- TOC entry 434 (class 1259 OID 31901)
-- Name: stock_opname; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_opname (
    id text NOT NULL,
    opname_date date,
    fk_organization text,
    fk_facility text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.stock_opname OWNER TO belian;

--
-- TOC entry 435 (class 1259 OID 31909)
-- Name: stock_opname_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.stock_opname_item (
    id text NOT NULL,
    onhand numeric(10,0) DEFAULT NULL::numeric,
    opnamed numeric(10,0) DEFAULT NULL::numeric,
    fk_product text,
    fk_parent text,
    note text,
    version bigint
);


ALTER TABLE belian.stock_opname_item OWNER TO belian;

--
-- TOC entry 436 (class 1259 OID 31918)
-- Name: student; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.student (
    id text NOT NULL,
    parent_name text,
    school_name text,
    source text DEFAULT 'Friend'::text
);


ALTER TABLE belian.student OWNER TO belian;

--
-- TOC entry 437 (class 1259 OID 31926)
-- Name: student_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.student_relationship (
    id text NOT NULL,
    fk_student text,
    fk_organization text
);


ALTER TABLE belian.student_relationship OWNER TO belian;

--
-- TOC entry 438 (class 1259 OID 31933)
-- Name: study_day; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.study_day (
    id text NOT NULL,
    is_sunday character(1) DEFAULT '0'::bpchar,
    is_monday character(1) DEFAULT '0'::bpchar,
    is_tuesday character(1) DEFAULT '0'::bpchar,
    is_wednesday character(1) DEFAULT '0'::bpchar,
    is_thrusday character(1) DEFAULT '0'::bpchar,
    is_friday character(1) DEFAULT '0'::bpchar,
    is_saturday character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.study_day OWNER TO belian;

--
-- TOC entry 439 (class 1259 OID 31948)
-- Name: study_period; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.study_period (
    id text NOT NULL,
    name text NOT NULL,
    note text,
    version bigint
);


ALTER TABLE belian.study_period OWNER TO belian;

--
-- TOC entry 440 (class 1259 OID 31955)
-- Name: study_room; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.study_room (
    id text NOT NULL,
    name text,
    fk_room text,
    fk_period text,
    fk_day text,
    fk_time text,
    fk_course text,
    fk_organization text,
    fk_feature text,
    fk_staff text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.study_room OWNER TO belian;

--
-- TOC entry 441 (class 1259 OID 31963)
-- Name: study_time; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.study_time (
    id text NOT NULL,
    start time without time zone,
    end_date time without time zone,
    version bigint DEFAULT 0
);


ALTER TABLE belian.study_time OWNER TO belian;

--
-- TOC entry 442 (class 1259 OID 31971)
-- Name: supplier; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.supplier (
    id text NOT NULL
);


ALTER TABLE belian.supplier OWNER TO belian;

--
-- TOC entry 443 (class 1259 OID 31978)
-- Name: supplier_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.supplier_relationship (
    id text NOT NULL,
    fk_supplier text,
    fk_internal_organization text
);


ALTER TABLE belian.supplier_relationship OWNER TO belian;

--
-- TOC entry 444 (class 1259 OID 31985)
-- Name: tax; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.tax (
    id text NOT NULL,
    code text,
    name text,
    note text,
    amount numeric(10,0) DEFAULT NULL::numeric,
    is_default character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.tax OWNER TO belian;

--
-- TOC entry 445 (class 1259 OID 31995)
-- Name: term_type; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.term_type (
    id text NOT NULL,
    description text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.term_type OWNER TO belian;

--
-- TOC entry 446 (class 1259 OID 32003)
-- Name: time_entry; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.time_entry (
    id text NOT NULL,
    start timestamp without time zone,
    end_date timestamp without time zone,
    hours integer,
    fk_timesheet text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.time_entry OWNER TO belian;

--
-- TOC entry 447 (class 1259 OID 32011)
-- Name: timesheet; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.timesheet (
    id text NOT NULL,
    start date,
    end_date date,
    comment text,
    worker_id text,
    worker_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.timesheet OWNER TO belian;

--
-- TOC entry 448 (class 1259 OID 32019)
-- Name: timesheet_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.timesheet_role (
    id text NOT NULL,
    timesheet_role_type text,
    fk_timesheet text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.timesheet_role OWNER TO belian;

--
-- TOC entry 449 (class 1259 OID 32027)
-- Name: transfer_order_request; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.transfer_order_request (
    id text NOT NULL
);


ALTER TABLE belian.transfer_order_request OWNER TO belian;

--
-- TOC entry 450 (class 1259 OID 32034)
-- Name: transfer_order_request_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.transfer_order_request_item (
    id text NOT NULL,
    fk_product text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_transfer_order text
);


ALTER TABLE belian.transfer_order_request_item OWNER TO belian;

--
-- TOC entry 451 (class 1259 OID 32042)
-- Name: treatment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.treatment (
    id text NOT NULL,
    is_bpjs character(1) DEFAULT '0'::bpchar,
    bpjs_payment_status text
);


ALTER TABLE belian.treatment OWNER TO belian;

--
-- TOC entry 452 (class 1259 OID 32050)
-- Name: treatment_item; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.treatment_item (
    id text NOT NULL,
    fk_product_treatment text,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    price numeric(10,0) DEFAULT NULL::numeric,
    discount numeric(10,0) DEFAULT NULL::numeric,
    textge numeric(10,0) DEFAULT NULL::numeric,
    note text,
    fk_treatment text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.treatment_item OWNER TO belian;

--
-- TOC entry 453 (class 1259 OID 32062)
-- Name: unit_of_measure; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.unit_of_measure (
    id text NOT NULL,
    code text,
    name text,
    note text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.unit_of_measure OWNER TO belian;

--
-- TOC entry 454 (class 1259 OID 32070)
-- Name: uom_factor; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.uom_factor (
    id text NOT NULL,
    factor numeric(10,0) DEFAULT NULL::numeric,
    fk_uom_from text,
    fk_uom_to text,
    version bigint
);


ALTER TABLE belian.uom_factor OWNER TO belian;

--
-- TOC entry 456 (class 1259 OID 32088)
-- Name: user_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.user_role (
    id text NOT NULL,
    fk_user text,
    fk_role text,
    role_name text,
    is_enabled character(1) DEFAULT '1'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.user_role OWNER TO belian;

--
-- TOC entry 457 (class 1259 OID 32097)
-- Name: user_setting; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.user_setting (
    id text NOT NULL,
    organization_id text,
    organization_value text,
    location_id text,
    location_value text,
    currency_id text,
    currency_value text,
    tax_id text,
    tax_value text,
    language text,
    row_per_page integer DEFAULT 25,
    printer_type text,
    version bigint,
    facility_id text,
    facility_value text
);


ALTER TABLE belian.user_setting OWNER TO belian;

--
-- TOC entry 458 (class 1259 OID 32105)
-- Name: work_effort; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort (
    id text NOT NULL,
    name text,
    description text,
    scheduled_start date,
    scheduled_end_date date,
    actual_start date,
    actual_end_date date,
    hours numeric(10,0) DEFAULT NULL::numeric,
    max_allowed_hours numeric(10,0) DEFAULT NULL::numeric,
    max_allowed_money numeric(10,0) DEFAULT NULL::numeric,
    purpose text,
    number text,
    creation_date date,
    organization_id text,
    organization_value text,
    type text,
    requester_id text,
    requester_value text,
    invoiced character(1) DEFAULT '0'::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort OWNER TO belian;

--
-- TOC entry 459 (class 1259 OID 32117)
-- Name: work_effort_asset_assignment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_asset_assignment (
    id text NOT NULL,
    start date,
    end_date date,
    cost numeric(10,0) DEFAULT NULL::numeric,
    rate numeric(10,0) DEFAULT 0,
    type text,
    fk_asset text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_asset_assignment OWNER TO belian;

--
-- TOC entry 460 (class 1259 OID 32127)
-- Name: work_effort_deliverable_produced; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_deliverable_produced (
    id text NOT NULL,
    fk_work_effort text,
    fk_deliverable text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_deliverable_produced OWNER TO belian;

--
-- TOC entry 461 (class 1259 OID 32135)
-- Name: work_effort_info; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_info (
    id text NOT NULL,
    name text,
    type text,
    hour numeric(10,0) DEFAULT NULL::numeric,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_info OWNER TO belian;

--
-- TOC entry 462 (class 1259 OID 32144)
-- Name: work_effort_inventory_assignment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_inventory_assignment (
    id text NOT NULL,
    quantity numeric(10,0) DEFAULT NULL::numeric,
    fk_inventory_item text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_inventory_assignment OWNER TO belian;

--
-- TOC entry 463 (class 1259 OID 32153)
-- Name: work_effort_inventorys_produced; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_inventorys_produced (
    id text NOT NULL,
    fk_work_effort text,
    fk_inventory_item text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_inventorys_produced OWNER TO belian;

--
-- TOC entry 464 (class 1259 OID 32161)
-- Name: work_effort_party_assignment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_party_assignment (
    id text NOT NULL,
    start date,
    end_date date,
    rate numeric(10,0) DEFAULT 0,
    party_id text,
    party_value text DEFAULT '0'::text,
    facility_id text,
    facility_value text,
    fk_work_effort text,
    type text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_party_assignment OWNER TO belian;

--
-- TOC entry 465 (class 1259 OID 32171)
-- Name: work_effort_party_rate; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_party_rate (
    id text NOT NULL,
    start date,
    end_date date,
    commend text,
    rate numeric(10,0) DEFAULT NULL::numeric,
    type text,
    fk_work_effort text,
    party_id text,
    party_value text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_party_rate OWNER TO belian;

--
-- TOC entry 466 (class 1259 OID 32180)
-- Name: work_effort_role; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_role (
    id text NOT NULL,
    type text,
    fk_party text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_role OWNER TO belian;

--
-- TOC entry 467 (class 1259 OID 32188)
-- Name: work_effort_status; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_effort_status (
    id text NOT NULL,
    start date,
    end_date date,
    type text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_effort_status OWNER TO belian;

--
-- TOC entry 468 (class 1259 OID 32196)
-- Name: work_order_item_fulfillment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_order_item_fulfillment (
    id text NOT NULL,
    order_item_id text,
    order_item_value text,
    order_id text,
    order_value text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_order_item_fulfillment OWNER TO belian;

--
-- TOC entry 469 (class 1259 OID 32204)
-- Name: work_requirement; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_requirement (
    id text NOT NULL,
    fk_production_info text,
    asset_id text,
    asset_value text,
    work_type text DEFAULT 'PROJECT'::text,
    product_id text,
    product_value text,
    quantity numeric(10,0) DEFAULT 1,
    fk_deliverable text
);


ALTER TABLE belian.work_requirement OWNER TO belian;

--
-- TOC entry 470 (class 1259 OID 32213)
-- Name: work_requirement_fulfillment; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.work_requirement_fulfillment (
    id text NOT NULL,
    requirement_id text,
    requirement_value text,
    fk_work_effort text,
    version bigint DEFAULT 0
);


ALTER TABLE belian.work_requirement_fulfillment OWNER TO belian;

--
-- TOC entry 471 (class 1259 OID 32221)
-- Name: worker; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.worker (
    id text NOT NULL
);


ALTER TABLE belian.worker OWNER TO belian;

--
-- TOC entry 472 (class 1259 OID 32228)
-- Name: worker_relationship; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.worker_relationship (
    id text NOT NULL,
    fk_worker text,
    fk_internal_organization text
);


ALTER TABLE belian.worker_relationship OWNER TO belian;

--
-- TOC entry 473 (class 1259 OID 32235)
-- Name: working_shift; Type: TABLE; Schema: belian; Owner: belian
--

CREATE TABLE belian.working_shift (
    id text NOT NULL,
    name text,
    start time without time zone,
    end_date time without time zone,
    is_active character(1) DEFAULT NULL::bpchar,
    version bigint DEFAULT 0
);


ALTER TABLE belian.working_shift OWNER TO belian;

--
-- TOC entry 5367 (class 0 OID 30714)
-- Dependencies: 317
-- Data for Name: access_module; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.access_module VALUES ('07452775-a048-4071-8798-21dc943fe926', 'PRODUCT', 'Product', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('0918f728-35b9-4028-940b-a343b16fd464', 'SALES_INVOICE', 'Sales Invoice', '', 'FINANCIAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('0b503053-31eb-410d-90a6-ec6a9977bc1e', 'FAMILY_FOLDER', 'Family Folder', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4', 'CLINIC_SALES', 'Clinic Sales', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('0cd0b486-647b-49b9-85a9-7d2eb44c7a42', 'TERM_TYPE', 'Order Term', '', 'SALES', 'Y', 1);
INSERT INTO belian.access_module VALUES ('1213903a-126f-4a60-8c7e-35c6dbe67927', 'PRODUCT_REQUIREMENT', 'Product Requirement', '', 'SALES', 'Y', 0);
INSERT INTO belian.access_module VALUES ('13989b38-ac2c-47b8-8708-5e27477af18d', 'BENEFIT_TYPE', 'Benefit Type', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('1adc4b8b-ad93-4658-8476-6bb13e2e810d', 'ORDERS_REQUEST', 'Purchase Order Request', '', 'PROCUREMENT', 'Y', 2);
INSERT INTO belian.access_module VALUES ('1cf392fc-4f93-4e38-9709-2beb84434951', 'DOCTORTYPE', 'Doctor Type', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('29ec80f0-0d4c-451c-ae5e-f195c4be1a27', 'COMPANY_STRUCTURE', 'Company Structure', '', 'GENERAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f', 'BUDGET_APPROVER', 'Budget Approver', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('2c0d9a06-cebd-4da2-b520-2e948aae3e53', 'INVOICE_REPORT', 'Invoice Report', '', 'FINANCIAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('2d7e5641-511d-43fd-a6d6-a482120f8aa5', 'BUDGET', 'Budget', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('314a3f13-a982-4915-a5cb-455eacbc27ae', 'INBOX', 'Inbox Message', '', 'SYSTEM', 'Y', 0);
INSERT INTO belian.access_module VALUES ('322d37f6-a667-481e-bc22-db212d0154ea', 'EMPYAPP', 'Employment Application', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('339d7200-9aa1-43d5-8683-e7118cb52839', 'STUDENT', 'Student', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('342b0b64-291f-4d12-bdb8-77186895d21d', 'SALES_REPORT', 'Sales Report', '', 'SALES', 'Y', 0);
INSERT INTO belian.access_module VALUES ('355ca995-6bae-4638-bfd4-a9bfeff5eefb', 'INVOICE_OVERDUE_REPORT', 'Invoice Over Due Report', '', 'FINANCIAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('4500a912-bbad-4590-9abb-d9ec92a311a5', 'DISCOUNT', 'Discount Programm', 'Discount', 'PAYMENT', 'Y', 1);
INSERT INTO belian.access_module VALUES ('4939e42f-06b5-4e44-b3ba-4106964f1f68', 'ACCOUNTINGPERIOD', 'Accounting Period', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('4b3bb551-173e-46f5-b1e9-bdd719e3045e', 'COA', 'General Chart of Account', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('4bf39427-b32a-434c-bd71-4d9493ea6eef', 'STOCK_OPNAME', 'Stock Opname', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('4eb93eb7-2100-49ae-bd96-a39995ed5670', 'USER', 'User', 'Application User Module', 'SECURITY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('4eca5501-a650-41d5-87c1-c091391d3608', 'SALES_ORDER', 'SALES_ORDER', '', 'SALES', 'Y', 0);
INSERT INTO belian.access_module VALUES ('532efe0a-05ff-4f94-877d-a7f3f7509569', 'WORKING_TIMESHEET', 'Working Timesheet', '', 'PRODUCTION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('55b7e0fb-a178-478b-a09e-4b753f161aeb', 'MEDICATION', 'Medication', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('56f26094-5f17-4985-bc55-6ce8f66dbc96', 'WORK_EFFORT', 'Work Effort', 'Work Effort', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('5844dc9e-2db6-4074-8103-3861566b042e', 'PRODUCT_FEATURE', 'Product Feature', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('58621810-2c8f-44ae-b9aa-b1e05ad32743', 'SUPPLIER', 'Supplier', '', 'PROCUREMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('5c37296e-ab30-4d07-bba3-342d4c403f48', 'INVITEM', 'Inventory Item', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30', 'POSITIONTYPERATE', 'Position Type Rate', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('5e8c4a66-e46a-4000-ae1c-bf536686b30f', 'TRN_ORDER_REQ', 'Transfer Order Request', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('5eda5016-f448-42dd-926b-52b10870e29c', 'STUDY_TIME', 'Study Time', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('627fb961-6cf0-4148-9451-0d1422095eb7', 'ACKNOWLEDGEMENT', 'Acknowledgement', '', 'SYSTEM', 'Y', 0);
INSERT INTO belian.access_module VALUES ('65414caf-3a73-4e3f-9a58-2d70c723b5bc', 'CURRENCY', 'Currency', 'GENERAL', 'ACCOUNTING', 'Y', 1);
INSERT INTO belian.access_module VALUES ('6861d3b3-8110-46ed-8a3a-830963597fa7', 'TAX', 'Tax', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('69443009-4a15-4061-b9f0-08c08c8f50aa', 'JOURNALENTRY', 'Journal Entry', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('6cbaf072-6925-46e9-b417-17326f3d8584', 'EMPLOYMENT', 'Employment', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('6e299ade-e10e-4940-ae83-bdf61505ed63', 'STUDENT_REGISTRATION', 'Student Registration', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('74ad4867-9495-472f-97fc-36bf87895585', 'COURSE_ATTENDANCE', 'Course Attendance', 'EDUCATION', 'EDUCATION', 'Y', 1);
INSERT INTO belian.access_module VALUES ('770c420c-f809-43f7-969c-b493f0b4ef48', 'CASHIER', 'Cashier', '', 'SALES', 'Y', 0);
INSERT INTO belian.access_module VALUES ('7bef1d92-0f15-43ef-b59b-5bc3e769d896', 'UOM', 'Unit of Measure', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('7f17176c-f27a-432c-a106-0d7d87b0afb7', 'RECEIPT', 'Receipt', '', 'PAYMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('80aebe74-399c-4273-9145-956a077d3f5d', 'ACCESS_ROLE', 'Role', 'Application Access Role', 'SECURITY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('8217c196-16b9-44fb-9662-8323220ee705', 'ASSET', 'Asset Management', '', 'ASSET', 'Y', 0);
INSERT INTO belian.access_module VALUES ('83b19678-9f2f-49f4-ba25-0f31a8dee078', 'PHARMACY_ORDER', 'Pharmacy Order', '', 'PHARMACY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('847a8df6-bc04-4de6-8d7d-28e41c00f422', 'DOCTOR_APPOINTMENT', 'Doctor Appointment', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('855aab16-cb45-41c3-b62c-55185ff77dfc', 'PHARMACY_SALES', 'Pharmacy Sales', '', 'PHARMACY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('88bf4008-c84a-4089-88c6-e9d8f077a196', 'JOURNALSETTING', 'Journal Setting', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('8a05b279-2f80-47b8-a2a7-63fbe96d327e', 'AUDIT_TRAIL', 'Audit Trail', '', 'SYSTEM', 'Y', 0);
INSERT INTO belian.access_module VALUES ('8a8db7c0-a8f6-4314-b45c-c40161275c20', 'WORK_REQUIREMENT', 'Work Requirement', 'Work Requirement', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('8c7e1020-0824-4239-9a4e-46301c80b9cd', 'PAYMENT_METHOD_TYPE', 'Payment Method Type', '', 'PAYMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e', 'ORGANIZATIONACCOUNT', 'Organization Account', '', 'ACCOUNTING', 'Y', 0);
INSERT INTO belian.access_module VALUES ('90195ecb-4674-4614-a429-eebc24ffe773', 'POSITIONTYPE', 'Position Type', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('916b22eb-48fa-4000-b7a2-7fc1d47ced4e', 'STOCK_ADJUSTMENT', 'Stock Adjustment', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9178e8cd-4063-4fe9-a060-d2e3ac818ed1', 'PAYCHECK', 'Paycheck', '', 'PAYMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('95dd39dd-512e-414e-b95c-0fc251887f98', 'PRODUCT_CATEGORY', 'Product Category', '', 'INVENTORY', 'Y', 1);
INSERT INTO belian.access_module VALUES ('99623cbd-066f-4cc2-b9b3-1961bed131cc', 'GOODS_TRANSFER', 'Goods Transfer', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9b9deb26-0960-478c-8cac-4ac475c3ffc3', 'COURSE_REGISTRATION', 'Course Registration', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9b9e014c-7a23-40c1-8841-30044564bf7f', 'MODULE', 'Module', 'Application Module', 'SECURITY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9b9e014c-7a23-40c1-8841-30044564bf7x', 'SYSTEM', 'System Access', 'System Access', 'SYSTEM', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9df71b1a-0e52-4445-98ea-b9a59ad81ac9', 'PATIENT', 'Patient', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('9e644628-121d-4954-8a66-8002cc866bda', 'STOCK_ADMIN', 'Stock Admin', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c', 'PERSON', 'Person Management', '', 'GENERAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('a4c43802-436f-407c-8793-323600c181d7', 'SHIPMENT_RECEIPT', 'Shipment Receipt', '', 'INVENTORY', 'Y', 1);
INSERT INTO belian.access_module VALUES ('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa', 'PRODUCT_RETUR', 'Product Retur', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('affcf2e7-fd2c-4b39-beee-97b5dc5a1405', 'STUDY_PERIOD', 'Study Period', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('b44420c6-261b-44c5-a23a-7802a0506dab', 'RECURRING_PAYMENT', 'Recurring Payment', '', 'PAYMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('b54c8e49-c820-4292-9f74-9e47bd55711f', 'PURCHASE_ORDER', 'Purchase Order', '', 'PROCUREMENT', 'Y', 1);
INSERT INTO belian.access_module VALUES ('b662de02-f4a3-4f1a-819b-5d2aaf6a342b', 'SHIPMENT_ISSUANCE', 'Shipment Issuance', '', 'INVENTORY', 'Y', 1);
INSERT INTO belian.access_module VALUES ('b9935030-f5c1-479e-9ec1-795afc1c1e7e', 'FACILITY', 'Facility', '', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2', 'PROFIT_LOSS', 'Profit Loss Report', '', 'FINANCIAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('c79e78d0-3427-440c-b8fe-df126e667a8b', 'INVOICE_DUEDATE_REPORT', 'Invoice Due Date Report', '', 'FINANCIAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('c8b588b7-d205-4f55-a2ca-e7c759d68efc', 'SHIPMENT', 'Shipment', 'Shipment', 'INVENTORY', 'Y', 0);
INSERT INTO belian.access_module VALUES ('d33784ca-abd5-422b-b45a-8c8ee13ddc0a', 'DEDUCTION_TYPE', 'Deduction Type', '', 'PAYMENT', 'Y', 0);
INSERT INTO belian.access_module VALUES ('dbc9175e-eb27-45e9-9e43-a1c12d6354e4', 'DOCTOR', 'Doctor', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('e4307d82-f3fa-4916-9e6b-7a4f894d847e', 'ORGANIZATION', 'Organization', '', 'GENERAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('e4d249e1-4bd5-4291-9050-62a99f70f64c', 'CLINIC_REPORT', 'Clinic Reports', '', 'CLINIC', 'Y', 0);
INSERT INTO belian.access_module VALUES ('e54e6ba5-7ffd-457b-a23e-8b6285867ba4', 'STUDY_ROOM', 'Study Room', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('e8f89299-2138-4167-b5b7-52f6ae1667ca', 'POSITION', 'Position', '', 'HR', 'Y', 0);
INSERT INTO belian.access_module VALUES ('e916392a-0b3c-4543-ada7-93054383bb3b', 'MESSAGE', 'Message', '', 'SYSTEM', 'Y', 0);
INSERT INTO belian.access_module VALUES ('ee3c3540-9c62-46df-a79e-f7b636a9ba1d', 'STUDY_DAY', 'Study Day', 'EDUCATION', 'EDUCATION', 'Y', 1);
INSERT INTO belian.access_module VALUES ('f50dd16d-0e25-44b6-bd69-c28dfcc55300', 'GEOGRAPHIC', 'Geographic', '', 'GENERAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('f53b80db-1b89-4779-86e7-b065b5287bbb', 'ASSET_TYPE', 'Asset Type', '', 'ASSET', 'Y', 0);
INSERT INTO belian.access_module VALUES ('fab64cd8-7762-412b-90fb-3d31d5576b45', 'COURSE_SCHEDULE', 'Course Schedule', '', 'EDUCATION', 'Y', 0);
INSERT INTO belian.access_module VALUES ('faeb1349-b68e-4695-9086-aaca794597f6', 'COUNTRY', 'Country', '', 'GENERAL', 'Y', 0);
INSERT INTO belian.access_module VALUES ('fca1cfcf-d199-4729-a321-e1ed01deb0f1', 'LABS_REGISTRATION', 'Laboratory Registration', '', 'MEDICALLAB', 'Y', 0);


--
-- TOC entry 5505 (class 0 OID 32078)
-- Dependencies: 455
-- Data for Name: access_user; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.access_user VALUES ('97dc9715-47eb-45d5-96ba-0a582fabdf3b', 'admin@belian.com', 'jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM', '1', '28fc7f13-1777-47e3-94c8-8b54436b1e96', '0', 1);


--
-- TOC entry 5265 (class 0 OID 28344)
-- Dependencies: 215
-- Data for Name: accounting_period; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5266 (class 0 OID 28352)
-- Dependencies: 216
-- Data for Name: acknowledgement; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5267 (class 0 OID 28361)
-- Dependencies: 217
-- Data for Name: address; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5268 (class 0 OID 28371)
-- Dependencies: 218
-- Data for Name: approve_and_reviewable; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5269 (class 0 OID 28379)
-- Dependencies: 219
-- Data for Name: asset; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5270 (class 0 OID 28389)
-- Dependencies: 220
-- Data for Name: asset_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5271 (class 0 OID 28396)
-- Dependencies: 221
-- Data for Name: audit_trail; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5272 (class 0 OID 28404)
-- Dependencies: 222
-- Data for Name: auto_journal_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5273 (class 0 OID 28412)
-- Dependencies: 223
-- Data for Name: benefit; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5274 (class 0 OID 28422)
-- Dependencies: 224
-- Data for Name: benefit_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5275 (class 0 OID 28430)
-- Dependencies: 225
-- Data for Name: billable; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5276 (class 0 OID 28439)
-- Dependencies: 226
-- Data for Name: bpjs; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5277 (class 0 OID 28448)
-- Dependencies: 227
-- Data for Name: budget; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5278 (class 0 OID 28456)
-- Dependencies: 228
-- Data for Name: budget_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5279 (class 0 OID 28464)
-- Dependencies: 229
-- Data for Name: budget_review; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5280 (class 0 OID 28471)
-- Dependencies: 230
-- Data for Name: budget_revision; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5281 (class 0 OID 28478)
-- Dependencies: 231
-- Data for Name: budget_revision_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5282 (class 0 OID 28485)
-- Dependencies: 232
-- Data for Name: budget_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5283 (class 0 OID 28492)
-- Dependencies: 233
-- Data for Name: budget_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5284 (class 0 OID 28499)
-- Dependencies: 234
-- Data for Name: carier_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5285 (class 0 OID 28506)
-- Dependencies: 235
-- Data for Name: carrier; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5286 (class 0 OID 28513)
-- Dependencies: 236
-- Data for Name: cash_purchase_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5287 (class 0 OID 28520)
-- Dependencies: 237
-- Data for Name: cash_purchase_order_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5288 (class 0 OID 28527)
-- Dependencies: 238
-- Data for Name: cash_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5289 (class 0 OID 28535)
-- Dependencies: 239
-- Data for Name: cash_sales_line; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5290 (class 0 OID 28547)
-- Dependencies: 240
-- Data for Name: cashier_shift; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5291 (class 0 OID 28557)
-- Dependencies: 241
-- Data for Name: citizenship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5292 (class 0 OID 28565)
-- Dependencies: 242
-- Data for Name: clinic_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5293 (class 0 OID 28574)
-- Dependencies: 243
-- Data for Name: clinic_sales_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5294 (class 0 OID 28586)
-- Dependencies: 244
-- Data for Name: company_structure; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5295 (class 0 OID 28594)
-- Dependencies: 245
-- Data for Name: contact; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5296 (class 0 OID 28604)
-- Dependencies: 246
-- Data for Name: container; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5297 (class 0 OID 28611)
-- Dependencies: 247
-- Data for Name: country; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5298 (class 0 OID 28619)
-- Dependencies: 248
-- Data for Name: course_attendance; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5299 (class 0 OID 28627)
-- Dependencies: 249
-- Data for Name: course_attendance_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5300 (class 0 OID 28636)
-- Dependencies: 250
-- Data for Name: course_discount; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5301 (class 0 OID 28645)
-- Dependencies: 251
-- Data for Name: course_installment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5302 (class 0 OID 28653)
-- Dependencies: 252
-- Data for Name: course_installment_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5303 (class 0 OID 28663)
-- Dependencies: 253
-- Data for Name: course_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5304 (class 0 OID 28673)
-- Dependencies: 254
-- Data for Name: course_registration; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5305 (class 0 OID 28681)
-- Dependencies: 255
-- Data for Name: course_schedule; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5306 (class 0 OID 28688)
-- Dependencies: 256
-- Data for Name: currency; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5307 (class 0 OID 28697)
-- Dependencies: 257
-- Data for Name: currency_exchange_factor; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5308 (class 0 OID 28706)
-- Dependencies: 258
-- Data for Name: deduction; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5309 (class 0 OID 28715)
-- Dependencies: 259
-- Data for Name: deduction_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5310 (class 0 OID 28723)
-- Dependencies: 260
-- Data for Name: deliverable; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5311 (class 0 OID 28731)
-- Dependencies: 261
-- Data for Name: disbursement; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5312 (class 0 OID 28738)
-- Dependencies: 262
-- Data for Name: discount; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5313 (class 0 OID 28748)
-- Dependencies: 263
-- Data for Name: doctor; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5314 (class 0 OID 28755)
-- Dependencies: 264
-- Data for Name: doctor_appointment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5315 (class 0 OID 28762)
-- Dependencies: 265
-- Data for Name: doctor_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5316 (class 0 OID 28769)
-- Dependencies: 266
-- Data for Name: doctor_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5317 (class 0 OID 28777)
-- Dependencies: 267
-- Data for Name: employee; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5318 (class 0 OID 28784)
-- Dependencies: 268
-- Data for Name: employer; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5319 (class 0 OID 29882)
-- Dependencies: 269
-- Data for Name: employment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5320 (class 0 OID 29889)
-- Dependencies: 270
-- Data for Name: employment_application; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5321 (class 0 OID 29897)
-- Dependencies: 271
-- Data for Name: erp_mode; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5322 (class 0 OID 29906)
-- Dependencies: 272
-- Data for Name: facility; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5323 (class 0 OID 29914)
-- Dependencies: 273
-- Data for Name: facility_organization; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5324 (class 0 OID 29923)
-- Dependencies: 274
-- Data for Name: family_folder; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5325 (class 0 OID 29931)
-- Dependencies: 275
-- Data for Name: family_member; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5326 (class 0 OID 29940)
-- Dependencies: 276
-- Data for Name: financial_account; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5327 (class 0 OID 29948)
-- Dependencies: 277
-- Data for Name: financial_account_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5328 (class 0 OID 29956)
-- Dependencies: 278
-- Data for Name: financial_account_transaction; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5329 (class 0 OID 29964)
-- Dependencies: 279
-- Data for Name: geographic; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5330 (class 0 OID 29973)
-- Dependencies: 280
-- Data for Name: gl_account; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5331 (class 0 OID 29981)
-- Dependencies: 281
-- Data for Name: gl_account_balance; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5332 (class 0 OID 29991)
-- Dependencies: 282
-- Data for Name: goods_issue; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5333 (class 0 OID 29999)
-- Dependencies: 283
-- Data for Name: goods_issue_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5334 (class 0 OID 30008)
-- Dependencies: 284
-- Data for Name: goods_transfer; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5335 (class 0 OID 30016)
-- Dependencies: 285
-- Data for Name: goods_transfer_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5336 (class 0 OID 30024)
-- Dependencies: 286
-- Data for Name: healtcare_practitioner; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5337 (class 0 OID 30031)
-- Dependencies: 287
-- Data for Name: healthcare_provider; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5338 (class 0 OID 30038)
-- Dependencies: 288
-- Data for Name: inbox; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5339 (class 0 OID 30048)
-- Dependencies: 289
-- Data for Name: internal_organization; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5340 (class 0 OID 30055)
-- Dependencies: 290
-- Data for Name: inventory_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5341 (class 0 OID 30474)
-- Dependencies: 291
-- Data for Name: invoice; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5342 (class 0 OID 30483)
-- Dependencies: 292
-- Data for Name: invoice_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5343 (class 0 OID 30494)
-- Dependencies: 293
-- Data for Name: invoice_order_item_billing; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5344 (class 0 OID 30504)
-- Dependencies: 294
-- Data for Name: invoice_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5345 (class 0 OID 30512)
-- Dependencies: 295
-- Data for Name: invoice_shipment_item_billing; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5346 (class 0 OID 30520)
-- Dependencies: 296
-- Data for Name: invoice_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5347 (class 0 OID 30528)
-- Dependencies: 297
-- Data for Name: invoice_term; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5348 (class 0 OID 30537)
-- Dependencies: 298
-- Data for Name: invoice_time_entry_billing; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5349 (class 0 OID 30546)
-- Dependencies: 299
-- Data for Name: invoice_work_effort_billing; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5350 (class 0 OID 30555)
-- Dependencies: 300
-- Data for Name: journal_entry; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5351 (class 0 OID 30565)
-- Dependencies: 301
-- Data for Name: journal_entry_detail; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5352 (class 0 OID 30574)
-- Dependencies: 302
-- Data for Name: journal_posting; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5353 (class 0 OID 30583)
-- Dependencies: 303
-- Data for Name: journal_setting; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5354 (class 0 OID 30591)
-- Dependencies: 304
-- Data for Name: laboratory; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5355 (class 0 OID 30600)
-- Dependencies: 305
-- Data for Name: laboratory_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5356 (class 0 OID 30612)
-- Dependencies: 306
-- Data for Name: laboratory_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5357 (class 0 OID 30621)
-- Dependencies: 307
-- Data for Name: laboratory_sales_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5358 (class 0 OID 30633)
-- Dependencies: 308
-- Data for Name: marital_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5359 (class 0 OID 30642)
-- Dependencies: 309
-- Data for Name: medical_record; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5360 (class 0 OID 30650)
-- Dependencies: 310
-- Data for Name: medical_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5361 (class 0 OID 30658)
-- Dependencies: 311
-- Data for Name: medical_treatment_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5362 (class 0 OID 30666)
-- Dependencies: 312
-- Data for Name: medical_treatment_sales_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5363 (class 0 OID 30678)
-- Dependencies: 313
-- Data for Name: medication; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5364 (class 0 OID 30686)
-- Dependencies: 314
-- Data for Name: medication_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5365 (class 0 OID 30698)
-- Dependencies: 315
-- Data for Name: message; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5366 (class 0 OID 30707)
-- Dependencies: 316
-- Data for Name: message_receiver; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5368 (class 0 OID 30724)
-- Dependencies: 318
-- Data for Name: notification; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5369 (class 0 OID 30732)
-- Dependencies: 319
-- Data for Name: order_adjustment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5370 (class 0 OID 30742)
-- Dependencies: 320
-- Data for Name: order_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5371 (class 0 OID 30758)
-- Dependencies: 321
-- Data for Name: order_item_assosiation; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5372 (class 0 OID 30766)
-- Dependencies: 322
-- Data for Name: order_payment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5373 (class 0 OID 30774)
-- Dependencies: 323
-- Data for Name: order_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5374 (class 0 OID 30783)
-- Dependencies: 324
-- Data for Name: order_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5375 (class 0 OID 30791)
-- Dependencies: 325
-- Data for Name: order_term; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5376 (class 0 OID 30799)
-- Dependencies: 326
-- Data for Name: order_value; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5377 (class 0 OID 30810)
-- Dependencies: 327
-- Data for Name: orders; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5378 (class 0 OID 30819)
-- Dependencies: 328
-- Data for Name: organization_account; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5379 (class 0 OID 30828)
-- Dependencies: 329
-- Data for Name: organization_gl_account; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5380 (class 0 OID 30837)
-- Dependencies: 330
-- Data for Name: organization_period; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5381 (class 0 OID 30846)
-- Dependencies: 331
-- Data for Name: party; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5382 (class 0 OID 30855)
-- Dependencies: 332
-- Data for Name: party_classification; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5383 (class 0 OID 30863)
-- Dependencies: 333
-- Data for Name: party_rate; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5384 (class 0 OID 30872)
-- Dependencies: 334
-- Data for Name: party_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5385 (class 0 OID 30880)
-- Dependencies: 335
-- Data for Name: party_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5386 (class 0 OID 30887)
-- Dependencies: 336
-- Data for Name: party_skill; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5387 (class 0 OID 30895)
-- Dependencies: 337
-- Data for Name: party_skill_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5388 (class 0 OID 30903)
-- Dependencies: 338
-- Data for Name: passport; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5389 (class 0 OID 30911)
-- Dependencies: 339
-- Data for Name: patient; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5390 (class 0 OID 30918)
-- Dependencies: 340
-- Data for Name: patient_practitioner_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5391 (class 0 OID 30925)
-- Dependencies: 341
-- Data for Name: patient_provider_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5392 (class 0 OID 30932)
-- Dependencies: 342
-- Data for Name: patient_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5393 (class 0 OID 30939)
-- Dependencies: 343
-- Data for Name: pay_history; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5394 (class 0 OID 30948)
-- Dependencies: 344
-- Data for Name: payable; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5395 (class 0 OID 30956)
-- Dependencies: 345
-- Data for Name: paycheck; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5396 (class 0 OID 30963)
-- Dependencies: 346
-- Data for Name: paycheck_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5397 (class 0 OID 30972)
-- Dependencies: 347
-- Data for Name: payment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5398 (class 0 OID 30981)
-- Dependencies: 348
-- Data for Name: payment_application; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5399 (class 0 OID 30989)
-- Dependencies: 349
-- Data for Name: payment_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5400 (class 0 OID 30997)
-- Dependencies: 350
-- Data for Name: payment_method_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5401 (class 0 OID 31005)
-- Dependencies: 351
-- Data for Name: payroll_preference; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5402 (class 0 OID 31015)
-- Dependencies: 352
-- Data for Name: pharmacy_sales; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5403 (class 0 OID 31023)
-- Dependencies: 353
-- Data for Name: pharmacy_sales_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5404 (class 0 OID 31035)
-- Dependencies: 354
-- Data for Name: physical_characteristic; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5405 (class 0 OID 31043)
-- Dependencies: 355
-- Data for Name: pick_list; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5406 (class 0 OID 31051)
-- Dependencies: 356
-- Data for Name: pick_list_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5407 (class 0 OID 31060)
-- Dependencies: 357
-- Data for Name: pos_sales_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5408 (class 0 OID 31067)
-- Dependencies: 358
-- Data for Name: position; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5409 (class 0 OID 31075)
-- Dependencies: 359
-- Data for Name: position_fulfillment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5410 (class 0 OID 31083)
-- Dependencies: 360
-- Data for Name: position_reporting_structure; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5411 (class 0 OID 31092)
-- Dependencies: 361
-- Data for Name: position_responsibility; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5412 (class 0 OID 31100)
-- Dependencies: 362
-- Data for Name: position_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5413 (class 0 OID 31108)
-- Dependencies: 363
-- Data for Name: position_type_rate; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5414 (class 0 OID 31117)
-- Dependencies: 364
-- Data for Name: practitioner_provider_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5415 (class 0 OID 31124)
-- Dependencies: 365
-- Data for Name: price_component; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5416 (class 0 OID 31133)
-- Dependencies: 366
-- Data for Name: product; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5417 (class 0 OID 31141)
-- Dependencies: 367
-- Data for Name: product_category; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5418 (class 0 OID 31149)
-- Dependencies: 368
-- Data for Name: product_category_classification; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5419 (class 0 OID 31158)
-- Dependencies: 369
-- Data for Name: product_code; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5420 (class 0 OID 31165)
-- Dependencies: 370
-- Data for Name: product_component; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5421 (class 0 OID 31174)
-- Dependencies: 371
-- Data for Name: product_cost; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5422 (class 0 OID 31183)
-- Dependencies: 372
-- Data for Name: product_feature; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5423 (class 0 OID 31191)
-- Dependencies: 373
-- Data for Name: product_feature_applicability; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5424 (class 0 OID 31199)
-- Dependencies: 374
-- Data for Name: product_identification; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5425 (class 0 OID 31206)
-- Dependencies: 375
-- Data for Name: product_price; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5426 (class 0 OID 31216)
-- Dependencies: 376
-- Data for Name: product_receivable; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5427 (class 0 OID 31223)
-- Dependencies: 377
-- Data for Name: product_requirement; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5428 (class 0 OID 31231)
-- Dependencies: 378
-- Data for Name: product_retur; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5429 (class 0 OID 31239)
-- Dependencies: 379
-- Data for Name: product_retur_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5430 (class 0 OID 31248)
-- Dependencies: 380
-- Data for Name: product_supplier; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5431 (class 0 OID 31256)
-- Dependencies: 381
-- Data for Name: production_info; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5432 (class 0 OID 31265)
-- Dependencies: 382
-- Data for Name: production_run_properties; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5433 (class 0 OID 31273)
-- Dependencies: 383
-- Data for Name: purchase_invoice; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5434 (class 0 OID 31280)
-- Dependencies: 384
-- Data for Name: purchase_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5435 (class 0 OID 31287)
-- Dependencies: 385
-- Data for Name: purchase_order_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5436 (class 0 OID 31296)
-- Dependencies: 386
-- Data for Name: purchase_order_request; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5437 (class 0 OID 31303)
-- Dependencies: 387
-- Data for Name: purchase_order_request_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5438 (class 0 OID 31312)
-- Dependencies: 388
-- Data for Name: purchase_order_request_review; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5439 (class 0 OID 31319)
-- Dependencies: 389
-- Data for Name: purchase_order_request_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5440 (class 0 OID 31326)
-- Dependencies: 390
-- Data for Name: purchase_order_request_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5441 (class 0 OID 31333)
-- Dependencies: 391
-- Data for Name: quantity_break; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5442 (class 0 OID 31343)
-- Dependencies: 392
-- Data for Name: quick_launch; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5443 (class 0 OID 31353)
-- Dependencies: 393
-- Data for Name: quote; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5444 (class 0 OID 31361)
-- Dependencies: 394
-- Data for Name: quote_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5445 (class 0 OID 31371)
-- Dependencies: 395
-- Data for Name: quote_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5446 (class 0 OID 31379)
-- Dependencies: 396
-- Data for Name: quote_term; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5447 (class 0 OID 31388)
-- Dependencies: 397
-- Data for Name: receipt; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5448 (class 0 OID 31395)
-- Dependencies: 398
-- Data for Name: receivable_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5449 (class 0 OID 31403)
-- Dependencies: 399
-- Data for Name: recurring_payment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5450 (class 0 OID 31410)
-- Dependencies: 400
-- Data for Name: request; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5451 (class 0 OID 31419)
-- Dependencies: 401
-- Data for Name: request_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5452 (class 0 OID 31429)
-- Dependencies: 402
-- Data for Name: request_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5453 (class 0 OID 31436)
-- Dependencies: 403
-- Data for Name: requirement; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5454 (class 0 OID 31445)
-- Dependencies: 404
-- Data for Name: requirement_order_commitment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5455 (class 0 OID 31454)
-- Dependencies: 405
-- Data for Name: requirement_request; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5456 (class 0 OID 31462)
-- Dependencies: 406
-- Data for Name: requirement_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5457 (class 0 OID 31469)
-- Dependencies: 407
-- Data for Name: requirement_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5458 (class 0 OID 31477)
-- Dependencies: 408
-- Data for Name: review; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5459 (class 0 OID 31485)
-- Dependencies: 409
-- Data for Name: role; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.role VALUES ('096b0105-de76-492c-9bb0-5e518b46d69c', 'Sys Admin', 'System Administrator', 'System Administrator', 0, 'Y');


--
-- TOC entry 5264 (class 0 OID 28331)
-- Dependencies: 214
-- Data for Name: role_module; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.role_module VALUES ('0043ec31-46d4-4dee-8d88-5212f55cd26c', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4500a912-bbad-4590-9abb-d9ec92a311a5', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('01f41120-c1d9-4372-8b7e-16e7acb817a3', '096b0105-de76-492c-9bb0-5e518b46d69c', '56f26094-5f17-4985-bc55-6ce8f66dbc96', 'WORK_EFFORT', 'Work Effort', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('01f5388b-c63e-4d09-b3b5-dd6456dd0815', '096b0105-de76-492c-9bb0-5e518b46d69c', 'c79e78d0-3427-440c-b8fe-df126e667a8b', 'INVOICE_DUEDATE_REPORT', 'Invoice Due Date Report', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('025b44ad-7c39-428d-8c96-3815e3d24182', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'a4aa9ae0-5166-4d06-afd1-d2eea6f2417c', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('032967cb-5aa5-44bb-96ae-877098c59420', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'b44420c6-261b-44c5-a23a-7802a0506dab', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('03cd6476-2d67-4f90-b95b-4b81d8a6ea46', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'e8f89299-2138-4167-b5b7-52f6ae1667ca', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('0442dff1-c1dd-45e7-8634-2b9d90904469', '096b0105-de76-492c-9bb0-5e518b46d69c', '7bef1d92-0f15-43ef-b59b-5bc3e769d896', 'UOM', 'Unit of Measure', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('060d3480-7c9a-44c7-b572-d7b2c4067359', '096b0105-de76-492c-9bb0-5e518b46d69c', '916b22eb-48fa-4000-b7a2-7fc1d47ced4e', 'STOCK_ADJUSTMENT', 'Stock Adjustment', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('0a1a6c1d-e681-48c4-b400-be611a9f70b7', '096b0105-de76-492c-9bb0-5e518b46d69c', '8a05b279-2f80-47b8-a2a7-63fbe96d327e', 'AUDIT_TRAIL', 'Audit Trail', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('0e9073d1-2be3-4a8a-9a82-5bd1166757e2', '096b0105-de76-492c-9bb0-5e518b46d69c', '847a8df6-bc04-4de6-8d7d-28e41c00f422', 'DOCTOR_APPOINTMENT', 'Doctor Appointment', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('11071b96-65a9-4a7c-b33f-8ddde228d695', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '1cf392fc-4f93-4e38-9709-2beb84434951', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('115145a2-9c2b-47be-a78d-73bf316a00c5', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '8c7e1020-0824-4239-9a4e-46301c80b9cd', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('13bd68bf-9e5f-4270-8680-621e92a3d19a', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'e4307d82-f3fa-4916-9e6b-7a4f894d847e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('15813a75-16cd-4e8f-a7ef-92ff0cc60781', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '8a8db7c0-a8f6-4314-b45c-c40161275c20', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('178186d0-5376-402d-9b91-01c92c03e7d8', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '342b0b64-291f-4d12-bdb8-77186895d21d', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('1785ddf0-ff6b-4451-91de-619c6ff90b1d', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '5cdd1545-8fdb-4a79-b2a3-0662ed6fec30', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('195dd074-a5e5-4abe-bc9f-5e913229bbb6', '096b0105-de76-492c-9bb0-5e518b46d69c', '2d7e5641-511d-43fd-a6d6-a482120f8aa5', 'BUDGET', 'Budget', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('1aa3a48c-ab0c-4949-945e-e9852a9b9a93', '096b0105-de76-492c-9bb0-5e518b46d69c', '95dd39dd-512e-414e-b95c-0fc251887f98', 'PRODUCT_CATEGORY', 'Product Category', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('1c60aaee-8072-4b5b-9a85-b71858287b80', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '99623cbd-066f-4cc2-b9b3-1961bed131cc', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('2276523a-e567-4880-935d-d9db9009c0d1', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'fab64cd8-7762-412b-90fb-3d31d5576b45', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('22dbda74-3437-4a1f-a3d1-0dac5edef600', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '88bf4008-c84a-4089-88c6-e9d8f077a196', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82', '096b0105-de76-492c-9bb0-5e518b46d69c', '5c37296e-ab30-4d07-bba3-342d4c403f48', 'INVITEM', 'Inventory Item', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('23b2e925-f5b7-43b5-aa83-982cab9aa8fd', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9b9deb26-0960-478c-8cac-4ac475c3ffc3', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('2b8087da-3212-41c5-bc3b-17299456ff52', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'faeb1349-b68e-4695-9086-aaca794597f6', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('2c661c0d-53b6-44c7-85bd-ba04da473be3', '096b0105-de76-492c-9bb0-5e518b46d69c', 'c0f3237c-23c2-49ab-bc9c-e00aa706d7e2', 'PROFIT_LOSS', 'Profit Loss Report', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('2c8857bc-15c8-4ab7-aecf-08c71225b2c2', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'fca1cfcf-d199-4729-a321-e1ed01deb0f1', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('2d52482a-0a7a-4e49-83c6-9db73e4e051b', '096b0105-de76-492c-9bb0-5e518b46d69c', '80aebe74-399c-4273-9145-956a077d3f5d', 'ACCESS_ROLE', 'Role', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('2e2c3346-a54d-4412-95b6-bb20aa338cc7', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '0918f728-35b9-4028-940b-a343b16fd464', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4', '096b0105-de76-492c-9bb0-5e518b46d69c', 'b54c8e49-c820-4292-9f74-9e47bd55711f', 'PURCHASE_ORDER', 'Purchase Order', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('32915e9c-96bf-44b3-881a-2f7c917a4c92', '096b0105-de76-492c-9bb0-5e518b46d69c', 'd33784ca-abd5-422b-b45a-8c8ee13ddc0a', 'DEDUCTION_TYPE', 'Deduction Type', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('32cc538f-0445-4ec4-9d2e-3084e89062d1', '096b0105-de76-492c-9bb0-5e518b46d69c', '7f17176c-f27a-432c-a106-0d7d87b0afb7', 'RECEIPT', 'Receipt', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('331300a2-cc8e-4417-abb3-45dadf814422', '096b0105-de76-492c-9bb0-5e518b46d69c', 'fca1cfcf-d199-4729-a321-e1ed01deb0f1', 'LABS_REGISTRATION', 'Laboratory Registration', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('37484efd-9cb6-4f79-903f-e7d6687658cc', '096b0105-de76-492c-9bb0-5e518b46d69c', '6861d3b3-8110-46ed-8a3a-830963597fa7', 'TAX', 'Tax', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('3a225b38-8dbd-482a-9c14-2f7f1c535068', '096b0105-de76-492c-9bb0-5e518b46d69c', '88bf4008-c84a-4089-88c6-e9d8f077a196', 'JOURNALSETTING', 'Journal Setting', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('3c1835ed-0038-432c-83df-7ec783b61860', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '0c586cf4-9bd2-4b93-b24b-d41ceca2aef4', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('403b2cbb-20ea-4bbc-b16d-76e3f1716504', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '314a3f13-a982-4915-a5cb-455eacbc27ae', NULL, NULL, '1', '0', '0', '0', '1', 2, NULL);
INSERT INTO belian.role_module VALUES ('4106810f-37bd-48a1-9bf4-6eedcef7af49', '096b0105-de76-492c-9bb0-5e518b46d69c', 'c8b588b7-d205-4f55-a2ca-e7c759d68efc', 'SHIPMENT', 'Shipment', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('4571a505-de22-4c81-90ca-775dc1cfdd7f', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9b9e014c-7a23-40c1-8841-30044564bf7f', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('48817f18-03eb-474d-9157-dd97c9ce4909', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'c8b588b7-d205-4f55-a2ca-e7c759d68efc', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('48c06de3-442f-4125-a438-e370fabade36', '096b0105-de76-492c-9bb0-5e518b46d69c', 'f50dd16d-0e25-44b6-bd69-c28dfcc55300', 'GEOGRAPHIC', 'Geographic', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('48c4056e-33f6-4082-af20-0139f3e66371', '096b0105-de76-492c-9bb0-5e518b46d69c', '8217c196-16b9-44fb-9662-8323220ee705', 'ASSET', 'Asset Management', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('490e4434-7ea2-475e-a66c-ea7296b82c54', '096b0105-de76-492c-9bb0-5e518b46d69c', '29ec80f0-0d4c-451c-ae5e-f195c4be1a27', 'COMPANY_STRUCTURE', 'Company Structure', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('4b0ecde0-df93-41b9-862a-bf6e5f839541', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '90195ecb-4674-4614-a429-eebc24ffe773', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('4b15a790-2920-47f2-b805-33ecd48b9bac', '096b0105-de76-492c-9bb0-5e518b46d69c', '2c0d9a06-cebd-4da2-b520-2e948aae3e53', 'INVOICE_REPORT', 'Invoice Report', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('4bc3906f-84ef-4f3f-bb2c-99200e0b6a94', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'c0f3237c-23c2-49ab-bc9c-e00aa706d7e2', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('4ffc7d67-b139-49bf-abfa-8b14fde333e8', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4eca5501-a650-41d5-87c1-c091391d3608', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('4fffeab2-b09c-47fb-92b4-3981da252637', '096b0105-de76-492c-9bb0-5e518b46d69c', '9e644628-121d-4954-8a66-8002cc866bda', 'STOCK_ADMIN', 'Stock Admin', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('534836de-b92b-4796-9acf-e93c272f185c', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '80aebe74-399c-4273-9145-956a077d3f5d', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('53c89b57-829c-4cb1-bc3c-6e9f783f5e8f', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '8a05b279-2f80-47b8-a2a7-63fbe96d327e', NULL, NULL, '1', '0', '0', '0', '1', 2, NULL);
INSERT INTO belian.role_module VALUES ('541dd297-fd64-44ae-bcf4-fed612227962', '096b0105-de76-492c-9bb0-5e518b46d69c', '4b3bb551-173e-46f5-b1e9-bdd719e3045e', 'COA', 'General Chart of Account', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('56b1e1d1-5a23-4932-9cf4-a5adbb7f08bf', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '2bdc3f95-c5bd-47d9-adce-9e9df1042e2f', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('5899665a-2bf5-4bc0-a249-46643db8f641', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '55b7e0fb-a178-478b-a09e-4b753f161aeb', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('59896828-7d8e-43a9-b8f8-c315fa774a15', '096b0105-de76-492c-9bb0-5e518b46d69c', '0cd0b486-647b-49b9-85a9-7d2eb44c7a42', 'TERM_TYPE', 'Order Term', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('59d88282-5a3f-481b-9bb8-91679fbf4d91', '096b0105-de76-492c-9bb0-5e518b46d69c', 'f53b80db-1b89-4779-86e7-b065b5287bbb', 'ASSET_TYPE', 'Asset Type', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('5a2ce59a-60c2-4203-9d3b-7c5d038fe635', '096b0105-de76-492c-9bb0-5e518b46d69c', 'e916392a-0b3c-4543-ada7-93054383bb3b', 'MESSAGE', 'Message', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('5c2ddb84-b28c-40f6-81d5-351e0ea1037d', '096b0105-de76-492c-9bb0-5e518b46d69c', '627fb961-6cf0-4148-9451-0d1422095eb7', 'ACKNOWLEDGEMENT', 'Acknowledgement', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('5c9ab463-dc50-47a5-a601-f074734adf3c', '096b0105-de76-492c-9bb0-5e518b46d69c', 'abfd9a02-3b4b-47a0-9048-a65b6be0b3aa', 'PRODUCT_RETUR', 'Product Retur', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('5f92972d-0be6-47df-9fef-571ead1a4b33', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'e54e6ba5-7ffd-457b-a23e-8b6285867ba4', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6179118a-ff80-452a-a89d-8e0154725095', '096b0105-de76-492c-9bb0-5e518b46d69c', 'b662de02-f4a3-4f1a-819b-5d2aaf6a342b', 'SHIPMENT_ISSUANCE', 'Shipment Issuance', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('62d1ce88-a8f0-4b77-9a0e-cfa5314a8599', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '07452775-a048-4071-8798-21dc943fe926', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('63101df7-be22-4b53-bba5-f6ad0b3d58cb', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'c79e78d0-3427-440c-b8fe-df126e667a8b', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6416ea67-8c7b-477e-811f-c5e4e45ca9c0', '096b0105-de76-492c-9bb0-5e518b46d69c', '99623cbd-066f-4cc2-b9b3-1961bed131cc', 'GOODS_TRANSFER', 'Goods Transfer', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('641e5498-7f09-4cd7-ae01-1bb2ee6f90a6', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '2c0d9a06-cebd-4da2-b520-2e948aae3e53', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('64a1ea08-9b16-4ad7-8597-1132af964f3c', '096b0105-de76-492c-9bb0-5e518b46d69c', '0918f728-35b9-4028-940b-a343b16fd464', 'SALES_INVOICE', 'Sales Invoice', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('6655f91e-4928-4c6f-b83a-f43b28f04454', '096b0105-de76-492c-9bb0-5e518b46d69c', '770c420c-f809-43f7-969c-b493f0b4ef48', 'CASHIER', 'Cashier', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('66ecfe3f-9d94-4891-a7ae-fdda3e9b0359', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4939e42f-06b5-4e44-b3ba-4106964f1f68', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6a302991-e66a-4ebe-9e6b-90b80d10825a', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '770c420c-f809-43f7-969c-b493f0b4ef48', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6adcd07b-62da-4e75-a076-80520a58eb32', '096b0105-de76-492c-9bb0-5e518b46d69c', '5cdd1545-8fdb-4a79-b2a3-0662ed6fec30', 'POSITIONTYPERATE', 'Position Type Rate', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('6b8c5725-0430-4ad3-a02b-6b88db94c588', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '339d7200-9aa1-43d5-8683-e7118cb52839', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6ce486a9-e346-432b-ac3f-1a1860e25594', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'd33784ca-abd5-422b-b45a-8c8ee13ddc0a', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('6e516bc7-d8c9-4657-ad29-cdb7baf02e35', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'e916392a-0b3c-4543-ada7-93054383bb3b', NULL, NULL, '1', '0', '0', '0', '1', 2, NULL);
INSERT INTO belian.role_module VALUES ('6ed261e4-7608-49cd-9953-a04e3ff8dfed', '096b0105-de76-492c-9bb0-5e518b46d69c', 'affcf2e7-fd2c-4b39-beee-97b5dc5a1405', 'STUDY_PERIOD', 'Study Period', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('70b7f0f5-7045-4ca5-86d9-5e05388fc194', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '5844dc9e-2db6-4074-8103-3861566b042e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('711417b0-a5ea-4c2e-8ab3-e5a96576b45b', '096b0105-de76-492c-9bb0-5e518b46d69c', '8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e', 'ORGANIZATIONACCOUNT', 'Organization Account', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('71479847-69f5-43fa-b7ce-00af42c28d4a', '096b0105-de76-492c-9bb0-5e518b46d69c', '339d7200-9aa1-43d5-8683-e7118cb52839', 'STUDENT', 'Student', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('71b9f928-ac18-4a43-9341-73e52e432b60', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '0cd0b486-647b-49b9-85a9-7d2eb44c7a42', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('724b174d-96ec-4152-a42c-2d03097b9aa9', '096b0105-de76-492c-9bb0-5e518b46d69c', '342b0b64-291f-4d12-bdb8-77186895d21d', 'SALES_REPORT', 'Sales Report', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('73ea355d-9bef-4358-b370-4576fa398aec', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('745a6c00-725c-4ec4-8930-e02e4553696e', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'f53b80db-1b89-4779-86e7-b065b5287bbb', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('776edbb0-8c17-4121-b9cb-3dc35997ce92', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '56f26094-5f17-4985-bc55-6ce8f66dbc96', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('78b1a078-373f-417f-9e60-1938c899995c', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '5eda5016-f448-42dd-926b-52b10870e29c', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('79450f94-0cbf-4c0d-ad76-3362a4abe180', '096b0105-de76-492c-9bb0-5e518b46d69c', '4eca5501-a650-41d5-87c1-c091391d3608', 'SALES_ORDER', 'SALES_ORDER', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('7c7f84ba-7080-40b6-9f32-df7b6f39452c', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9df71b1a-0e52-4445-98ea-b9a59ad81ac9', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('7d026611-2dbd-4f37-8df7-7f4cecac13ec', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '916b22eb-48fa-4000-b7a2-7fc1d47ced4e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('7eeba1cc-d68e-4e23-a931-bd512f98ce81', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'ee3c3540-9c62-46df-a79e-f7b636a9ba1d', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('7f861ab6-1a52-4b30-bd29-a8609e8c5e5b', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9b9e014c-7a23-40c1-8841-30044564bf7x', NULL, NULL, '1', '0', '0', '0', '1', 2, NULL);
INSERT INTO belian.role_module VALUES ('8295829f-8ca5-45aa-8e97-de0af2550048', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '5e8c4a66-e46a-4000-ae1c-bf536686b30f', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('8617eee1-de5c-4122-b5a9-7d936bd34554', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9e644628-121d-4954-8a66-8002cc866bda', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('86971eb8-fc85-4c3f-8066-f5a0ff397806', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'affcf2e7-fd2c-4b39-beee-97b5dc5a1405', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('87f3c6fe-0ba0-4761-8198-2266bb7c03aa', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '1adc4b8b-ad93-4658-8476-6bb13e2e810d', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('89c3b455-3c46-4bc4-9a13-77c171e129b6', '096b0105-de76-492c-9bb0-5e518b46d69c', 'a4c43802-436f-407c-8793-323600c181d7', 'SHIPMENT_RECEIPT', 'Shipment Receipt', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('8c6f9ab1-f804-45c2-8504-9d9cc9d3199c', '096b0105-de76-492c-9bb0-5e518b46d69c', '532efe0a-05ff-4f94-877d-a7f3f7509569', 'WORKING_TIMESHEET', 'Working Timesheet', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('8d131962-9833-4dc5-8235-0c4d920dab41', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '855aab16-cb45-41c3-b62c-55185ff77dfc', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('8e4419be-5f68-4f46-ac6d-99bc45541173', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '74ad4867-9495-472f-97fc-36bf87895585', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('8fc78447-1fee-4e90-88be-a0eea402feea', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '9178e8cd-4063-4fe9-a060-d2e3ac818ed1', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('923b7b67-a1e4-478a-9769-e2ee32b685b1', '096b0105-de76-492c-9bb0-5e518b46d69c', 'ee3c3540-9c62-46df-a79e-f7b636a9ba1d', 'STUDY_DAY', 'Study Day', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('94863d4d-7d07-41d2-bc78-4f65260776d6', '096b0105-de76-492c-9bb0-5e518b46d69c', '13989b38-ac2c-47b8-8708-5e27477af18d', 'BENEFIT_TYPE', 'Benefit Type', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('96318b3e-baf7-479b-ab07-d0798114d3bd', '096b0105-de76-492c-9bb0-5e518b46d69c', 'e54e6ba5-7ffd-457b-a23e-8b6285867ba4', 'STUDY_ROOM', 'Study Room', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('9659ee34-7845-4078-89bd-9ee9b9e37b78', '096b0105-de76-492c-9bb0-5e518b46d69c', '855aab16-cb45-41c3-b62c-55185ff77dfc', 'PHARMACY_SALES', 'Pharmacy Sales', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('9728b76b-eac0-44c4-9ba9-afca669e0a76', '096b0105-de76-492c-9bb0-5e518b46d69c', 'e8f89299-2138-4167-b5b7-52f6ae1667ca', 'POSITION', 'Position', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('9b476230-013c-4e00-9ca9-bf7b5bd66478', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '58621810-2c8f-44ae-b9aa-b1e05ad32743', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('9f52d7a0-217e-4084-9bb3-78c5c81dd536', '096b0105-de76-492c-9bb0-5e518b46d69c', '07452775-a048-4071-8798-21dc943fe926', 'PRODUCT', 'Product', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('9fa511a1-e704-4018-a90a-57acea0ac5da', '096b0105-de76-492c-9bb0-5e518b46d69c', '1adc4b8b-ad93-4658-8476-6bb13e2e810d', 'ORDERS_REQUEST', 'Purchase Order Request', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('a055f787-df6a-4c93-af22-12797bf5ec39', '096b0105-de76-492c-9bb0-5e518b46d69c', '69443009-4a15-4061-b9f0-08c08c8f50aa', 'JOURNALENTRY', 'Journal Entry', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('a19d3eed-e7cb-4389-9e7b-1b6b0cfad032', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'dbc9175e-eb27-45e9-9e43-a1c12d6354e4', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('a2d02360-afb3-4de3-843e-f2b0821ee293', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '2d7e5641-511d-43fd-a6d6-a482120f8aa5', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('a3e8ba06-d955-4929-bd36-f658f3796b6c', '096b0105-de76-492c-9bb0-5e518b46d69c', 'a4aa9ae0-5166-4d06-afd1-d2eea6f2417c', 'PERSON', 'Person Management', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('a3ef8fbd-46f9-43db-ab47-31d062c3fb20', '096b0105-de76-492c-9bb0-5e518b46d69c', '74ad4867-9495-472f-97fc-36bf87895585', 'COURSE_ATTENDANCE', 'Course Attendance', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('a41031e7-e779-40cd-8e6e-ef496cfdc366', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'b9935030-f5c1-479e-9ec1-795afc1c1e7e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('a658bb8f-a9f3-4eba-a64a-a23ccb1e03b0', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '29ec80f0-0d4c-451c-ae5e-f195c4be1a27', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('a7951344-6b9e-438f-af5c-7b94dee26b2d', '096b0105-de76-492c-9bb0-5e518b46d69c', '83b19678-9f2f-49f4-ba25-0f31a8dee078', 'PHARMACY_ORDER', 'Pharmacy Order', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('a8a90cc0-470f-456c-879b-77c0ed469dd7', '096b0105-de76-492c-9bb0-5e518b46d69c', '9df71b1a-0e52-4445-98ea-b9a59ad81ac9', 'PATIENT', 'Patient', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('a91848d3-83d1-485a-9846-c83ff3699ac2', '096b0105-de76-492c-9bb0-5e518b46d69c', '322d37f6-a667-481e-bc22-db212d0154ea', 'EMPYAPP', 'Employment Application', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('a99016f0-9078-472b-928d-2ceaf0be627a', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '95dd39dd-512e-414e-b95c-0fc251887f98', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('abea8c4e-8d38-4a46-b4f0-2401343cc8a5', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'e4d249e1-4bd5-4291-9050-62a99f70f64c', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('abecab92-51cb-4ca9-88a0-9446c1bc5ae3', '096b0105-de76-492c-9bb0-5e518b46d69c', '4eb93eb7-2100-49ae-bd96-a39995ed5670', 'USER', 'User', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('ac144c04-22c4-47fb-8fd4-3783a4f29a90', '096b0105-de76-492c-9bb0-5e518b46d69c', '1cf392fc-4f93-4e38-9709-2beb84434951', 'DOCTORTYPE', 'Doctor Type', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('ad389302-f250-4270-a937-75cf984c2f80', '096b0105-de76-492c-9bb0-5e518b46d69c', '2bdc3f95-c5bd-47d9-adce-9e9df1042e2f', 'BUDGET_APPROVER', 'Budget Approver', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('af724352-26da-43a3-ae25-43f322bece19', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'a4c43802-436f-407c-8793-323600c181d7', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('afe0e208-aaf2-45c0-9399-6b6526840ec1', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '7f17176c-f27a-432c-a106-0d7d87b0afb7', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91', '096b0105-de76-492c-9bb0-5e518b46d69c', '355ca995-6bae-4638-bfd4-a9bfeff5eefb', 'INVOICE_OVERDUE_REPORT', 'Invoice Over Due Report', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('b3739e51-6293-498a-bfa5-4c032b88fd3d', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '65414caf-3a73-4e3f-9a58-2d70c723b5bc', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b457fa72-9509-4497-97ae-19865cce0487', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4eb93eb7-2100-49ae-bd96-a39995ed5670', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b4f04a2c-d9a4-4b30-b75b-4572685e35a8', '096b0105-de76-492c-9bb0-5e518b46d69c', '9178e8cd-4063-4fe9-a060-d2e3ac818ed1', 'PAYCHECK', 'Paycheck', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('b7e387f5-ab32-4894-aba3-15e91e95a477', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '69443009-4a15-4061-b9f0-08c08c8f50aa', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b8bcfde1-100d-416b-b8e1-baac42d8b3e8', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '13989b38-ac2c-47b8-8708-5e27477af18d', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b93973c4-88cb-4edd-84f1-2b28c63ec8ad', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '5c37296e-ab30-4d07-bba3-342d4c403f48', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('b9cf782f-29cf-491f-8956-b066dd4f1a40', '096b0105-de76-492c-9bb0-5e518b46d69c', '1213903a-126f-4a60-8c7e-35c6dbe67927', 'PRODUCT_REQUIREMENT', 'Product Requirement', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('b9e3cb9e-bc2b-47de-968e-2fd696da5014', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'b54c8e49-c820-4292-9f74-9e47bd55711f', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('bd997bd7-73d9-4a60-88cd-7e2271a7eef1', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'f50dd16d-0e25-44b6-bd69-c28dfcc55300', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('bf839209-25d9-4ea7-8e4a-d771f7599e2e', '096b0105-de76-492c-9bb0-5e518b46d69c', '6cbaf072-6925-46e9-b417-17326f3d8584', 'EMPLOYMENT', 'Employment', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('c0ea0111-01b2-49d4-9cf0-f047e0051860', '096b0105-de76-492c-9bb0-5e518b46d69c', 'faeb1349-b68e-4695-9086-aaca794597f6', 'COUNTRY', 'Country', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('c15f6072-7e86-48ab-9069-3ae077493f5f', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '322d37f6-a667-481e-bc22-db212d0154ea', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('c2679569-2f15-4f50-8a5a-febbac3ec646', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '847a8df6-bc04-4de6-8d7d-28e41c00f422', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc', '096b0105-de76-492c-9bb0-5e518b46d69c', '9b9deb26-0960-478c-8cac-4ac475c3ffc3', 'COURSE_REGISTRATION', 'Course Registration', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('c3ae49cc-98cb-4e81-a518-b46d08cbcf54', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4b3bb551-173e-46f5-b1e9-bdd719e3045e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('c5c35685-920c-4f1e-bec3-6926cb19dbf2', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '355ca995-6bae-4638-bfd4-a9bfeff5eefb', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('c655e02a-f2a3-4132-8bd7-9428cc1ce3af', '096b0105-de76-492c-9bb0-5e518b46d69c', '0b503053-31eb-410d-90a6-ec6a9977bc1e', 'FAMILY_FOLDER', 'Family Folder', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('c836928e-da88-414e-b572-db436cc948a4', '096b0105-de76-492c-9bb0-5e518b46d69c', '4939e42f-06b5-4e44-b3ba-4106964f1f68', 'ACCOUNTINGPERIOD', 'Accounting Period', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('c9681985-0b2a-4537-822b-8f477bc15104', '096b0105-de76-492c-9bb0-5e518b46d69c', '65414caf-3a73-4e3f-9a58-2d70c723b5bc', 'CURRENCY', 'Currency', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('ce7241d6-dd5f-4f8e-b4b7-5ed8658120b1', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '7bef1d92-0f15-43ef-b59b-5bc3e769d896', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd', '096b0105-de76-492c-9bb0-5e518b46d69c', '314a3f13-a982-4915-a5cb-455eacbc27ae', 'INBOX', 'Inbox Message', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('cf021b8c-61cc-49ac-b0f1-a2721e66cf5e', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '0b503053-31eb-410d-90a6-ec6a9977bc1e', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('cf2437ad-5e59-4f7a-8190-f537beabc623', '096b0105-de76-492c-9bb0-5e518b46d69c', '58621810-2c8f-44ae-b9aa-b1e05ad32743', 'SUPPLIER', 'Supplier', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('cff3c8ef-bd79-4d32-be37-b4a2e7dab027', '096b0105-de76-492c-9bb0-5e518b46d69c', '90195ecb-4674-4614-a429-eebc24ffe773', 'POSITIONTYPE', 'Position Type', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('d11fbe57-0eac-4f6f-bc22-14a0ed221733', '096b0105-de76-492c-9bb0-5e518b46d69c', 'fab64cd8-7762-412b-90fb-3d31d5576b45', 'COURSE_SCHEDULE', 'Course Schedule', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('d6d952f8-33c2-4ed0-a371-a846572f573e', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '4bf39427-b32a-434c-bd71-4d9493ea6eef', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('d8a71d8e-344a-4c18-88ff-9ca2cffed715', '096b0105-de76-492c-9bb0-5e518b46d69c', 'b9935030-f5c1-479e-9ec1-795afc1c1e7e', 'FACILITY', 'Facility', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('de2ab421-31cd-45b7-b6d7-5baf50797f2c', '096b0105-de76-492c-9bb0-5e518b46d69c', '6e299ade-e10e-4940-ae83-bdf61505ed63', 'STUDENT_REGISTRATION', 'Student Registration', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('df2207bf-ec0b-44f2-b020-edb3e35edeba', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'b662de02-f4a3-4f1a-819b-5d2aaf6a342b', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('e1ae7cc5-aab3-4271-a744-9d17fca44e9c', '096b0105-de76-492c-9bb0-5e518b46d69c', '9b9e014c-7a23-40c1-8841-30044564bf7f', 'MODULE', 'Module', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('e1ae7cc5-aab3-4271-a744-9d17fca44e9x', '096b0105-de76-492c-9bb0-5e518b46d69c', '9b9e014c-7a23-40c1-8841-30044564bf7x', 'SYSTEM', 'System Access', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('e51c5ad1-38c7-4699-9c92-50f070f7a7f3', '096b0105-de76-492c-9bb0-5e518b46d69c', '4bf39427-b32a-434c-bd71-4d9493ea6eef', 'STOCK_OPNAME', 'Stock Opname', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('e6f44dd7-9616-4c85-aaa9-e5322ea39319', '096b0105-de76-492c-9bb0-5e518b46d69c', 'b44420c6-261b-44c5-a23a-7802a0506dab', 'RECURRING_PAYMENT', 'Recurring Payment', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('e75602fb-2d83-462c-8692-bb8ec206c395', '096b0105-de76-492c-9bb0-5e518b46d69c', '8a8db7c0-a8f6-4314-b45c-c40161275c20', 'WORK_REQUIREMENT', 'Work Requirement', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('e9b3d5e4-1259-48bc-b521-7abb7d72bc30', '096b0105-de76-492c-9bb0-5e518b46d69c', 'e4307d82-f3fa-4916-9e6b-7a4f894d847e', 'ORGANIZATION', 'Organization', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('ebf6409b-1cf3-46aa-80b9-3041091c442b', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '627fb961-6cf0-4148-9451-0d1422095eb7', NULL, NULL, '1', '0', '0', '0', '1', 2, NULL);
INSERT INTO belian.role_module VALUES ('ebf9f4a1-27f9-4c16-9186-905c6d292287', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', 'abfd9a02-3b4b-47a0-9048-a65b6be0b3aa', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('ed0df929-8852-42ca-9006-e0ad6fd37a90', '096b0105-de76-492c-9bb0-5e518b46d69c', '55b7e0fb-a178-478b-a09e-4b753f161aeb', 'MEDICATION', 'Medication', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('ee5e29eb-cf8a-4c54-a709-da55952b8f80', '096b0105-de76-492c-9bb0-5e518b46d69c', '5eda5016-f448-42dd-926b-52b10870e29c', 'STUDY_TIME', 'Study Time', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('ee77b8ba-08c2-421d-b0a0-652945c04688', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '532efe0a-05ff-4f94-877d-a7f3f7509569', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('f0c0441f-80df-4405-8927-c114d9c61edb', '096b0105-de76-492c-9bb0-5e518b46d69c', 'e4d249e1-4bd5-4291-9050-62a99f70f64c', 'CLINIC_REPORT', 'Clinic Reports', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('f0f949d7-f756-4fdc-bacd-b6e145b9829d', '096b0105-de76-492c-9bb0-5e518b46d69c', '5e8c4a66-e46a-4000-ae1c-bf536686b30f', 'TRN_ORDER_REQ', 'Transfer Order Request', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('f21a4567-0723-4569-abd7-8e59e3645767', '096b0105-de76-492c-9bb0-5e518b46d69c', '0c586cf4-9bd2-4b93-b24b-d41ceca2aef4', 'CLINIC_SALES', 'Clinic Sales', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('f4b12ef0-6f04-4e2c-ac0c-bbb5ba7c8aee', '096b0105-de76-492c-9bb0-5e518b46d69c', '5844dc9e-2db6-4074-8103-3861566b042e', 'PRODUCT_FEATURE', 'Product Feature', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('f5040411-7d4c-4171-a3e8-1d5249c4b40e', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '1213903a-126f-4a60-8c7e-35c6dbe67927', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('f54456cf-21e6-4fa4-8732-45e15c59c0d5', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '6e299ade-e10e-4940-ae83-bdf61505ed63', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('f6e1681a-d510-4287-a66b-7cff66db5825', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '6861d3b3-8110-46ed-8a3a-830963597fa7', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('f6e69991-8825-41e8-a6e7-24a4c6257c4d', '096b0105-de76-492c-9bb0-5e518b46d69c', 'dbc9175e-eb27-45e9-9e43-a1c12d6354e4', 'DOCTOR', 'Doctor', '1', '1', '1', '1', '1', 0, NULL);
INSERT INTO belian.role_module VALUES ('f7284b39-b584-4334-94f0-0631d3a9b429', '096b0105-de76-492c-9bb0-5e518b46d69c', '4500a912-bbad-4590-9abb-d9ec92a311a5', 'DISCOUNT', 'Discount Programm', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('f904e603-9224-4316-b8fd-0f92fef2de85', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '83b19678-9f2f-49f4-ba25-0f31a8dee078', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('fccec2f5-a554-402a-aca6-edf3d4336c91', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '8217c196-16b9-44fb-9662-8323220ee705', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);
INSERT INTO belian.role_module VALUES ('fe2ef334-8861-41af-887a-a95992d46b74', '096b0105-de76-492c-9bb0-5e518b46d69c', '8c7e1020-0824-4239-9a4e-46301c80b9cd', 'PAYMENT_METHOD_TYPE', 'Payment Method Type', '1', '1', '1', '1', '1', 1, NULL);
INSERT INTO belian.role_module VALUES ('fe6ff4a0-77d6-4483-81be-520f46e85918', 'cecab92d-1762-4eb0-b45b-484e32e99fa3', '6cbaf072-6925-46e9-b417-17326f3d8584', NULL, NULL, '0', '0', '0', '0', '0', 0, NULL);


--
-- TOC entry 5460 (class 0 OID 31492)
-- Dependencies: 410
-- Data for Name: roled; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5461 (class 0 OID 31501)
-- Dependencies: 411
-- Data for Name: sales_invoice; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5462 (class 0 OID 31508)
-- Dependencies: 412
-- Data for Name: sales_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5463 (class 0 OID 31515)
-- Dependencies: 413
-- Data for Name: sales_order_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5464 (class 0 OID 31522)
-- Dependencies: 414
-- Data for Name: sequence_number; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5465 (class 0 OID 31531)
-- Dependencies: 415
-- Data for Name: shipment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5466 (class 0 OID 31542)
-- Dependencies: 416
-- Data for Name: shipment_issuance; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5467 (class 0 OID 31550)
-- Dependencies: 417
-- Data for Name: shipment_issuance_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5468 (class 0 OID 31560)
-- Dependencies: 418
-- Data for Name: shipment_issuance_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5469 (class 0 OID 31766)
-- Dependencies: 419
-- Data for Name: shipment_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5470 (class 0 OID 31776)
-- Dependencies: 420
-- Data for Name: shipment_order; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5471 (class 0 OID 31786)
-- Dependencies: 421
-- Data for Name: shipment_receipt; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5472 (class 0 OID 31795)
-- Dependencies: 422
-- Data for Name: shipment_receipt_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5473 (class 0 OID 31806)
-- Dependencies: 423
-- Data for Name: shipment_receipt_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5474 (class 0 OID 31814)
-- Dependencies: 424
-- Data for Name: shipment_route_segment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5475 (class 0 OID 31825)
-- Dependencies: 425
-- Data for Name: shipment_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5476 (class 0 OID 31833)
-- Dependencies: 426
-- Data for Name: shipping_document; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5477 (class 0 OID 31841)
-- Dependencies: 427
-- Data for Name: simple_invoice_clinic; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5478 (class 0 OID 31850)
-- Dependencies: 428
-- Data for Name: simple_invoice_clinic_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5479 (class 0 OID 31859)
-- Dependencies: 429
-- Data for Name: statuses; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5480 (class 0 OID 31867)
-- Dependencies: 430
-- Data for Name: stock_adjustment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5481 (class 0 OID 31875)
-- Dependencies: 431
-- Data for Name: stock_adjustment_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5482 (class 0 OID 31884)
-- Dependencies: 432
-- Data for Name: stock_admin; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5483 (class 0 OID 31891)
-- Dependencies: 433
-- Data for Name: stock_history; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5484 (class 0 OID 31901)
-- Dependencies: 434
-- Data for Name: stock_opname; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5485 (class 0 OID 31909)
-- Dependencies: 435
-- Data for Name: stock_opname_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5486 (class 0 OID 31918)
-- Dependencies: 436
-- Data for Name: student; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5487 (class 0 OID 31926)
-- Dependencies: 437
-- Data for Name: student_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5488 (class 0 OID 31933)
-- Dependencies: 438
-- Data for Name: study_day; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5489 (class 0 OID 31948)
-- Dependencies: 439
-- Data for Name: study_period; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5490 (class 0 OID 31955)
-- Dependencies: 440
-- Data for Name: study_room; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5491 (class 0 OID 31963)
-- Dependencies: 441
-- Data for Name: study_time; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5492 (class 0 OID 31971)
-- Dependencies: 442
-- Data for Name: supplier; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5493 (class 0 OID 31978)
-- Dependencies: 443
-- Data for Name: supplier_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5494 (class 0 OID 31985)
-- Dependencies: 444
-- Data for Name: tax; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5495 (class 0 OID 31995)
-- Dependencies: 445
-- Data for Name: term_type; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5496 (class 0 OID 32003)
-- Dependencies: 446
-- Data for Name: time_entry; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5497 (class 0 OID 32011)
-- Dependencies: 447
-- Data for Name: timesheet; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5498 (class 0 OID 32019)
-- Dependencies: 448
-- Data for Name: timesheet_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5499 (class 0 OID 32027)
-- Dependencies: 449
-- Data for Name: transfer_order_request; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5500 (class 0 OID 32034)
-- Dependencies: 450
-- Data for Name: transfer_order_request_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5501 (class 0 OID 32042)
-- Dependencies: 451
-- Data for Name: treatment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5502 (class 0 OID 32050)
-- Dependencies: 452
-- Data for Name: treatment_item; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5503 (class 0 OID 32062)
-- Dependencies: 453
-- Data for Name: unit_of_measure; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5504 (class 0 OID 32070)
-- Dependencies: 454
-- Data for Name: uom_factor; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5506 (class 0 OID 32088)
-- Dependencies: 456
-- Data for Name: user_role; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.user_role VALUES ('849138a5-4b4e-41ea-8f24-e4586e7f8ab9', '97dc9715-47eb-45d5-96ba-0a582fabdf3b', '096b0105-de76-492c-9bb0-5e518b46d69c', 'System Administrator', '1', 0);


--
-- TOC entry 5507 (class 0 OID 32097)
-- Dependencies: 457
-- Data for Name: user_setting; Type: TABLE DATA; Schema: belian; Owner: belian
--

INSERT INTO belian.user_setting VALUES ('28fc7f13-1777-47e3-94c8-8b54436b1e96', NULL, NULL, 'c4c10aee-a3a1-4e6c-a08b-62d4e26414df', 'Pontianak', '85c90912-97ff-47ce-9d6a-7d1650ab3ea9', 'Rupiah', NULL, NULL, 'in_id', 25, 'STANDARD', 14, NULL, NULL);


--
-- TOC entry 5508 (class 0 OID 32105)
-- Dependencies: 458
-- Data for Name: work_effort; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5509 (class 0 OID 32117)
-- Dependencies: 459
-- Data for Name: work_effort_asset_assignment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5510 (class 0 OID 32127)
-- Dependencies: 460
-- Data for Name: work_effort_deliverable_produced; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5511 (class 0 OID 32135)
-- Dependencies: 461
-- Data for Name: work_effort_info; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5512 (class 0 OID 32144)
-- Dependencies: 462
-- Data for Name: work_effort_inventory_assignment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5513 (class 0 OID 32153)
-- Dependencies: 463
-- Data for Name: work_effort_inventorys_produced; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5514 (class 0 OID 32161)
-- Dependencies: 464
-- Data for Name: work_effort_party_assignment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5515 (class 0 OID 32171)
-- Dependencies: 465
-- Data for Name: work_effort_party_rate; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5516 (class 0 OID 32180)
-- Dependencies: 466
-- Data for Name: work_effort_role; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5517 (class 0 OID 32188)
-- Dependencies: 467
-- Data for Name: work_effort_status; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5518 (class 0 OID 32196)
-- Dependencies: 468
-- Data for Name: work_order_item_fulfillment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5519 (class 0 OID 32204)
-- Dependencies: 469
-- Data for Name: work_requirement; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5520 (class 0 OID 32213)
-- Dependencies: 470
-- Data for Name: work_requirement_fulfillment; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5521 (class 0 OID 32221)
-- Dependencies: 471
-- Data for Name: worker; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5522 (class 0 OID 32228)
-- Dependencies: 472
-- Data for Name: worker_relationship; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 5523 (class 0 OID 32235)
-- Dependencies: 473
-- Data for Name: working_shift; Type: TABLE DATA; Schema: belian; Owner: belian
--



--
-- TOC entry 4809 (class 2606 OID 30723)
-- Name: access_module access_module_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.access_module
    ADD CONSTRAINT access_module_pk_id PRIMARY KEY (id);


--
-- TOC entry 4603 (class 2606 OID 28343)
-- Name: role_module access_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.role_module
    ADD CONSTRAINT access_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5085 (class 2606 OID 32087)
-- Name: access_user access_user_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.access_user
    ADD CONSTRAINT access_user_pk_id PRIMARY KEY (id);


--
-- TOC entry 4605 (class 2606 OID 28351)
-- Name: accounting_period accounting_period_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.accounting_period
    ADD CONSTRAINT accounting_period_pk_id PRIMARY KEY (id);


--
-- TOC entry 4607 (class 2606 OID 28360)
-- Name: acknowledgement acknowledgement_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.acknowledgement
    ADD CONSTRAINT acknowledgement_pk_id PRIMARY KEY (id);


--
-- TOC entry 4609 (class 2606 OID 28370)
-- Name: address address_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.address
    ADD CONSTRAINT address_pk_id PRIMARY KEY (id);


--
-- TOC entry 4611 (class 2606 OID 28378)
-- Name: approve_and_reviewable approve_and_reviewable_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.approve_and_reviewable
    ADD CONSTRAINT approve_and_reviewable_pk_id PRIMARY KEY (id);


--
-- TOC entry 4613 (class 2606 OID 28388)
-- Name: asset asset_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.asset
    ADD CONSTRAINT asset_pk_id PRIMARY KEY (id);


--
-- TOC entry 4615 (class 2606 OID 28395)
-- Name: asset_type asset_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.asset_type
    ADD CONSTRAINT asset_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4617 (class 2606 OID 28403)
-- Name: audit_trail audit_trail_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.audit_trail
    ADD CONSTRAINT audit_trail_pk_id PRIMARY KEY (id);


--
-- TOC entry 4619 (class 2606 OID 28411)
-- Name: auto_journal_sales auto_journal_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.auto_journal_sales
    ADD CONSTRAINT auto_journal_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4621 (class 2606 OID 28421)
-- Name: benefit benefit_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.benefit
    ADD CONSTRAINT benefit_pk_id PRIMARY KEY (id);


--
-- TOC entry 4623 (class 2606 OID 28429)
-- Name: benefit_type benefit_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.benefit_type
    ADD CONSTRAINT benefit_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4625 (class 2606 OID 28438)
-- Name: billable billable_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.billable
    ADD CONSTRAINT billable_pk_id PRIMARY KEY (id);


--
-- TOC entry 4627 (class 2606 OID 28447)
-- Name: bpjs bpjs_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.bpjs
    ADD CONSTRAINT bpjs_pk_id PRIMARY KEY (id);


--
-- TOC entry 4631 (class 2606 OID 28463)
-- Name: budget_item budget_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_item
    ADD CONSTRAINT budget_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4629 (class 2606 OID 28455)
-- Name: budget budget_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget
    ADD CONSTRAINT budget_pk_id PRIMARY KEY (id);


--
-- TOC entry 4633 (class 2606 OID 28470)
-- Name: budget_review budget_review_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_review
    ADD CONSTRAINT budget_review_pk_id PRIMARY KEY (id);


--
-- TOC entry 4637 (class 2606 OID 28484)
-- Name: budget_revision_item budget_revision_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_revision_item
    ADD CONSTRAINT budget_revision_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4635 (class 2606 OID 28477)
-- Name: budget_revision budget_revision_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_revision
    ADD CONSTRAINT budget_revision_pk_id PRIMARY KEY (id);


--
-- TOC entry 4639 (class 2606 OID 28491)
-- Name: budget_role budget_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_role
    ADD CONSTRAINT budget_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4641 (class 2606 OID 28498)
-- Name: budget_status budget_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.budget_status
    ADD CONSTRAINT budget_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4643 (class 2606 OID 28505)
-- Name: carier_relationship carier_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.carier_relationship
    ADD CONSTRAINT carier_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4645 (class 2606 OID 28512)
-- Name: carrier carrier_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.carrier
    ADD CONSTRAINT carrier_pk_id PRIMARY KEY (id);


--
-- TOC entry 4649 (class 2606 OID 28526)
-- Name: cash_purchase_order_item cash_purchase_order_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.cash_purchase_order_item
    ADD CONSTRAINT cash_purchase_order_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4647 (class 2606 OID 28519)
-- Name: cash_purchase_order cash_purchase_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.cash_purchase_order
    ADD CONSTRAINT cash_purchase_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 4653 (class 2606 OID 28546)
-- Name: cash_sales_line cash_sales_line_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.cash_sales_line
    ADD CONSTRAINT cash_sales_line_pk_id PRIMARY KEY (id);


--
-- TOC entry 4651 (class 2606 OID 28534)
-- Name: cash_sales cash_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.cash_sales
    ADD CONSTRAINT cash_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4655 (class 2606 OID 28556)
-- Name: cashier_shift cashier_shift_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.cashier_shift
    ADD CONSTRAINT cashier_shift_pk_id PRIMARY KEY (id);


--
-- TOC entry 4657 (class 2606 OID 28564)
-- Name: citizenship citizenship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.citizenship
    ADD CONSTRAINT citizenship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4661 (class 2606 OID 28585)
-- Name: clinic_sales_item clinic_sales_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.clinic_sales_item
    ADD CONSTRAINT clinic_sales_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4659 (class 2606 OID 28572)
-- Name: clinic_sales clinic_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.clinic_sales
    ADD CONSTRAINT clinic_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4663 (class 2606 OID 28593)
-- Name: company_structure company_structure_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.company_structure
    ADD CONSTRAINT company_structure_pk_id PRIMARY KEY (id);


--
-- TOC entry 4665 (class 2606 OID 28603)
-- Name: contact contact_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.contact
    ADD CONSTRAINT contact_pk_id PRIMARY KEY (id);


--
-- TOC entry 4667 (class 2606 OID 28610)
-- Name: container container_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.container
    ADD CONSTRAINT container_pk_id PRIMARY KEY (id);


--
-- TOC entry 4669 (class 2606 OID 28618)
-- Name: country country_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.country
    ADD CONSTRAINT country_pk_id PRIMARY KEY (id);


--
-- TOC entry 4673 (class 2606 OID 28635)
-- Name: course_attendance_item course_attendance_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_attendance_item
    ADD CONSTRAINT course_attendance_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4671 (class 2606 OID 28626)
-- Name: course_attendance course_attendance_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_attendance
    ADD CONSTRAINT course_attendance_pk_id PRIMARY KEY (id);


--
-- TOC entry 4675 (class 2606 OID 28644)
-- Name: course_discount course_discount_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_discount
    ADD CONSTRAINT course_discount_pk_id PRIMARY KEY (id);


--
-- TOC entry 4679 (class 2606 OID 28662)
-- Name: course_installment_item course_installment_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_installment_item
    ADD CONSTRAINT course_installment_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4677 (class 2606 OID 28652)
-- Name: course_installment course_installment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_installment
    ADD CONSTRAINT course_installment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4681 (class 2606 OID 28672)
-- Name: course_item course_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_item
    ADD CONSTRAINT course_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4683 (class 2606 OID 28680)
-- Name: course_registration course_registration_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_registration
    ADD CONSTRAINT course_registration_pk_id PRIMARY KEY (id);


--
-- TOC entry 4685 (class 2606 OID 28687)
-- Name: course_schedule course_schedule_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.course_schedule
    ADD CONSTRAINT course_schedule_pk_id PRIMARY KEY (id);


--
-- TOC entry 4689 (class 2606 OID 28705)
-- Name: currency_exchange_factor currency_exchange_factor_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.currency_exchange_factor
    ADD CONSTRAINT currency_exchange_factor_pk_id PRIMARY KEY (id);


--
-- TOC entry 4687 (class 2606 OID 28696)
-- Name: currency currency_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.currency
    ADD CONSTRAINT currency_pk_id PRIMARY KEY (id);


--
-- TOC entry 4691 (class 2606 OID 28714)
-- Name: deduction deduction_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.deduction
    ADD CONSTRAINT deduction_pk_id PRIMARY KEY (id);


--
-- TOC entry 4693 (class 2606 OID 28722)
-- Name: deduction_type deduction_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.deduction_type
    ADD CONSTRAINT deduction_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4695 (class 2606 OID 28730)
-- Name: deliverable deliverable_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.deliverable
    ADD CONSTRAINT deliverable_pk_id PRIMARY KEY (id);


--
-- TOC entry 4697 (class 2606 OID 28737)
-- Name: disbursement disbursement_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.disbursement
    ADD CONSTRAINT disbursement_pk_id PRIMARY KEY (id);


--
-- TOC entry 4699 (class 2606 OID 28747)
-- Name: discount discount_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.discount
    ADD CONSTRAINT discount_pk_id PRIMARY KEY (id);


--
-- TOC entry 4703 (class 2606 OID 28761)
-- Name: doctor_appointment doctor_appointment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.doctor_appointment
    ADD CONSTRAINT doctor_appointment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4701 (class 2606 OID 28754)
-- Name: doctor doctor_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.doctor
    ADD CONSTRAINT doctor_pk_id PRIMARY KEY (id);


--
-- TOC entry 4705 (class 2606 OID 28768)
-- Name: doctor_relationship doctor_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.doctor_relationship
    ADD CONSTRAINT doctor_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4707 (class 2606 OID 28776)
-- Name: doctor_type doctor_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.doctor_type
    ADD CONSTRAINT doctor_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4709 (class 2606 OID 28783)
-- Name: employee employee_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.employee
    ADD CONSTRAINT employee_pk_id PRIMARY KEY (id);


--
-- TOC entry 4711 (class 2606 OID 28790)
-- Name: employer employer_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.employer
    ADD CONSTRAINT employer_pk_id PRIMARY KEY (id);


--
-- TOC entry 4715 (class 2606 OID 29896)
-- Name: employment_application employment_application_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.employment_application
    ADD CONSTRAINT employment_application_pk_id PRIMARY KEY (id);


--
-- TOC entry 4713 (class 2606 OID 29888)
-- Name: employment employment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.employment
    ADD CONSTRAINT employment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4717 (class 2606 OID 29905)
-- Name: erp_mode erp_mode_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.erp_mode
    ADD CONSTRAINT erp_mode_pk_id PRIMARY KEY (id);


--
-- TOC entry 4721 (class 2606 OID 29922)
-- Name: facility_organization facility_organization_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.facility_organization
    ADD CONSTRAINT facility_organization_pk_id PRIMARY KEY (id);


--
-- TOC entry 4719 (class 2606 OID 29913)
-- Name: facility facility_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.facility
    ADD CONSTRAINT facility_pk_id PRIMARY KEY (id);


--
-- TOC entry 4723 (class 2606 OID 29930)
-- Name: family_folder family_folder_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.family_folder
    ADD CONSTRAINT family_folder_pk_id PRIMARY KEY (id);


--
-- TOC entry 4725 (class 2606 OID 29939)
-- Name: family_member family_member_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.family_member
    ADD CONSTRAINT family_member_pk_id PRIMARY KEY (id);


--
-- TOC entry 4727 (class 2606 OID 29947)
-- Name: financial_account financial_account_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.financial_account
    ADD CONSTRAINT financial_account_pk_id PRIMARY KEY (id);


--
-- TOC entry 4729 (class 2606 OID 29955)
-- Name: financial_account_role financial_account_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.financial_account_role
    ADD CONSTRAINT financial_account_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4731 (class 2606 OID 29963)
-- Name: financial_account_transaction financial_account_transaction_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.financial_account_transaction
    ADD CONSTRAINT financial_account_transaction_pk_id PRIMARY KEY (id);


--
-- TOC entry 4733 (class 2606 OID 29972)
-- Name: geographic geographic_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.geographic
    ADD CONSTRAINT geographic_pk_id PRIMARY KEY (id);


--
-- TOC entry 4737 (class 2606 OID 29990)
-- Name: gl_account_balance gl_account_balance_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.gl_account_balance
    ADD CONSTRAINT gl_account_balance_pk_id PRIMARY KEY (id);


--
-- TOC entry 4735 (class 2606 OID 29980)
-- Name: gl_account gl_account_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.gl_account
    ADD CONSTRAINT gl_account_pk_id PRIMARY KEY (id);


--
-- TOC entry 4741 (class 2606 OID 30007)
-- Name: goods_issue_item goods_issue_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.goods_issue_item
    ADD CONSTRAINT goods_issue_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4739 (class 2606 OID 29998)
-- Name: goods_issue goods_issue_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.goods_issue
    ADD CONSTRAINT goods_issue_pk_id PRIMARY KEY (id);


--
-- TOC entry 4745 (class 2606 OID 30023)
-- Name: goods_transfer_item goods_transfer_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.goods_transfer_item
    ADD CONSTRAINT goods_transfer_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4743 (class 2606 OID 30015)
-- Name: goods_transfer goods_transfer_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.goods_transfer
    ADD CONSTRAINT goods_transfer_pk_id PRIMARY KEY (id);


--
-- TOC entry 4747 (class 2606 OID 30030)
-- Name: healtcare_practitioner healtcare_practitioner_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.healtcare_practitioner
    ADD CONSTRAINT healtcare_practitioner_pk_id PRIMARY KEY (id);


--
-- TOC entry 4749 (class 2606 OID 30037)
-- Name: healthcare_provider healthcare_provider_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.healthcare_provider
    ADD CONSTRAINT healthcare_provider_pk_id PRIMARY KEY (id);


--
-- TOC entry 4751 (class 2606 OID 30047)
-- Name: inbox inbox_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.inbox
    ADD CONSTRAINT inbox_pk_id PRIMARY KEY (id);


--
-- TOC entry 4753 (class 2606 OID 30054)
-- Name: internal_organization internal_organization_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.internal_organization
    ADD CONSTRAINT internal_organization_pk_id PRIMARY KEY (id);


--
-- TOC entry 4755 (class 2606 OID 30064)
-- Name: inventory_item inventory_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.inventory_item
    ADD CONSTRAINT inventory_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4759 (class 2606 OID 30493)
-- Name: invoice_item invoice_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_item
    ADD CONSTRAINT invoice_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4761 (class 2606 OID 30503)
-- Name: invoice_order_item_billing invoice_order_item_billing_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_order_item_billing
    ADD CONSTRAINT invoice_order_item_billing_pk_id PRIMARY KEY (id);


--
-- TOC entry 4757 (class 2606 OID 30482)
-- Name: invoice invoice_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice
    ADD CONSTRAINT invoice_pk_id PRIMARY KEY (id);


--
-- TOC entry 4763 (class 2606 OID 30511)
-- Name: invoice_role invoice_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_role
    ADD CONSTRAINT invoice_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4765 (class 2606 OID 30519)
-- Name: invoice_shipment_item_billing invoice_shipment_item_billing_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_shipment_item_billing
    ADD CONSTRAINT invoice_shipment_item_billing_pk_id PRIMARY KEY (id);


--
-- TOC entry 4767 (class 2606 OID 30527)
-- Name: invoice_status invoice_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_status
    ADD CONSTRAINT invoice_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4769 (class 2606 OID 30536)
-- Name: invoice_term invoice_term_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_term
    ADD CONSTRAINT invoice_term_pk_id PRIMARY KEY (id);


--
-- TOC entry 4771 (class 2606 OID 30545)
-- Name: invoice_time_entry_billing invoice_time_entry_billing_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_time_entry_billing
    ADD CONSTRAINT invoice_time_entry_billing_pk_id PRIMARY KEY (id);


--
-- TOC entry 4773 (class 2606 OID 30554)
-- Name: invoice_work_effort_billing invoice_work_effort_billing_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.invoice_work_effort_billing
    ADD CONSTRAINT invoice_work_effort_billing_pk_id PRIMARY KEY (id);


--
-- TOC entry 4777 (class 2606 OID 30573)
-- Name: journal_entry_detail journal_entry_detail_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.journal_entry_detail
    ADD CONSTRAINT journal_entry_detail_pk_id PRIMARY KEY (id);


--
-- TOC entry 4775 (class 2606 OID 30564)
-- Name: journal_entry journal_entry_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.journal_entry
    ADD CONSTRAINT journal_entry_pk_id PRIMARY KEY (id);


--
-- TOC entry 4779 (class 2606 OID 30582)
-- Name: journal_posting journal_posting_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.journal_posting
    ADD CONSTRAINT journal_posting_pk_id PRIMARY KEY (id);


--
-- TOC entry 4781 (class 2606 OID 30590)
-- Name: journal_setting journal_setting_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.journal_setting
    ADD CONSTRAINT journal_setting_pk_id PRIMARY KEY (id);


--
-- TOC entry 4785 (class 2606 OID 30611)
-- Name: laboratory_item laboratory_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.laboratory_item
    ADD CONSTRAINT laboratory_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4783 (class 2606 OID 30599)
-- Name: laboratory laboratory_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.laboratory
    ADD CONSTRAINT laboratory_pk_id PRIMARY KEY (id);


--
-- TOC entry 4789 (class 2606 OID 30632)
-- Name: laboratory_sales_item laboratory_sales_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.laboratory_sales_item
    ADD CONSTRAINT laboratory_sales_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4787 (class 2606 OID 30620)
-- Name: laboratory_sales laboratory_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.laboratory_sales
    ADD CONSTRAINT laboratory_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4791 (class 2606 OID 30641)
-- Name: marital_status marital_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.marital_status
    ADD CONSTRAINT marital_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4793 (class 2606 OID 30649)
-- Name: medical_record medical_record_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medical_record
    ADD CONSTRAINT medical_record_pk_id PRIMARY KEY (id);


--
-- TOC entry 4795 (class 2606 OID 30657)
-- Name: medical_sales medical_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medical_sales
    ADD CONSTRAINT medical_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4799 (class 2606 OID 30677)
-- Name: medical_treatment_sales_item medical_treatment_sales_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medical_treatment_sales_item
    ADD CONSTRAINT medical_treatment_sales_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4797 (class 2606 OID 30665)
-- Name: medical_treatment_sales medical_treatment_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medical_treatment_sales
    ADD CONSTRAINT medical_treatment_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4803 (class 2606 OID 30697)
-- Name: medication_item medication_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medication_item
    ADD CONSTRAINT medication_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4801 (class 2606 OID 30685)
-- Name: medication medication_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.medication
    ADD CONSTRAINT medication_pk_id PRIMARY KEY (id);


--
-- TOC entry 4805 (class 2606 OID 30706)
-- Name: message message_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.message
    ADD CONSTRAINT message_pk_id PRIMARY KEY (id);


--
-- TOC entry 4807 (class 2606 OID 30713)
-- Name: message_receiver message_receiver_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.message_receiver
    ADD CONSTRAINT message_receiver_pk_id PRIMARY KEY (id);


--
-- TOC entry 4811 (class 2606 OID 30731)
-- Name: notification notification_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.notification
    ADD CONSTRAINT notification_pk_id PRIMARY KEY (id);


--
-- TOC entry 4813 (class 2606 OID 30741)
-- Name: order_adjustment order_adjustment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_adjustment
    ADD CONSTRAINT order_adjustment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4817 (class 2606 OID 30765)
-- Name: order_item_assosiation order_item_assosiation_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_item_assosiation
    ADD CONSTRAINT order_item_assosiation_pk_id PRIMARY KEY (id);


--
-- TOC entry 4815 (class 2606 OID 30757)
-- Name: order_item order_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_item
    ADD CONSTRAINT order_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4819 (class 2606 OID 30773)
-- Name: order_payment order_payment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_payment
    ADD CONSTRAINT order_payment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4821 (class 2606 OID 30782)
-- Name: order_role order_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_role
    ADD CONSTRAINT order_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4823 (class 2606 OID 30790)
-- Name: order_status order_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_status
    ADD CONSTRAINT order_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4825 (class 2606 OID 30798)
-- Name: order_term order_term_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_term
    ADD CONSTRAINT order_term_pk_id PRIMARY KEY (id);


--
-- TOC entry 4827 (class 2606 OID 30809)
-- Name: order_value order_value_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.order_value
    ADD CONSTRAINT order_value_pk_id PRIMARY KEY (id);


--
-- TOC entry 4829 (class 2606 OID 30818)
-- Name: orders orders_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.orders
    ADD CONSTRAINT orders_pk_id PRIMARY KEY (id);


--
-- TOC entry 4831 (class 2606 OID 30827)
-- Name: organization_account organization_account_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.organization_account
    ADD CONSTRAINT organization_account_pk_id PRIMARY KEY (id);


--
-- TOC entry 4833 (class 2606 OID 30836)
-- Name: organization_gl_account organization_gl_account_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.organization_gl_account
    ADD CONSTRAINT organization_gl_account_pk_id PRIMARY KEY (id);


--
-- TOC entry 4835 (class 2606 OID 30845)
-- Name: organization_period organization_period_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.organization_period
    ADD CONSTRAINT organization_period_pk_id PRIMARY KEY (id);


--
-- TOC entry 4839 (class 2606 OID 30862)
-- Name: party_classification party_classification_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_classification
    ADD CONSTRAINT party_classification_pk_id PRIMARY KEY (id);


--
-- TOC entry 4837 (class 2606 OID 30854)
-- Name: party party_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party
    ADD CONSTRAINT party_pk_id PRIMARY KEY (id);


--
-- TOC entry 4841 (class 2606 OID 30871)
-- Name: party_rate party_rate_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_rate
    ADD CONSTRAINT party_rate_pk_id PRIMARY KEY (id);


--
-- TOC entry 4843 (class 2606 OID 30879)
-- Name: party_relationship party_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_relationship
    ADD CONSTRAINT party_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4845 (class 2606 OID 30886)
-- Name: party_role party_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_role
    ADD CONSTRAINT party_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4847 (class 2606 OID 30894)
-- Name: party_skill party_skill_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_skill
    ADD CONSTRAINT party_skill_pk_id PRIMARY KEY (id);


--
-- TOC entry 4849 (class 2606 OID 30902)
-- Name: party_skill_type party_skill_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.party_skill_type
    ADD CONSTRAINT party_skill_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4851 (class 2606 OID 30910)
-- Name: passport passport_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.passport
    ADD CONSTRAINT passport_pk_id PRIMARY KEY (id);


--
-- TOC entry 4853 (class 2606 OID 30917)
-- Name: patient patient_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.patient
    ADD CONSTRAINT patient_pk_id PRIMARY KEY (id);


--
-- TOC entry 4855 (class 2606 OID 30924)
-- Name: patient_practitioner_relationship patient_practitioner_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.patient_practitioner_relationship
    ADD CONSTRAINT patient_practitioner_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4857 (class 2606 OID 30931)
-- Name: patient_provider_relationship patient_provider_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.patient_provider_relationship
    ADD CONSTRAINT patient_provider_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4859 (class 2606 OID 30938)
-- Name: patient_relationship patient_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.patient_relationship
    ADD CONSTRAINT patient_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4861 (class 2606 OID 30947)
-- Name: pay_history pay_history_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pay_history
    ADD CONSTRAINT pay_history_pk_id PRIMARY KEY (id);


--
-- TOC entry 4863 (class 2606 OID 30955)
-- Name: payable payable_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payable
    ADD CONSTRAINT payable_pk_id PRIMARY KEY (id);


--
-- TOC entry 4867 (class 2606 OID 30971)
-- Name: paycheck_item paycheck_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.paycheck_item
    ADD CONSTRAINT paycheck_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4865 (class 2606 OID 30962)
-- Name: paycheck paycheck_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.paycheck
    ADD CONSTRAINT paycheck_pk_id PRIMARY KEY (id);


--
-- TOC entry 4871 (class 2606 OID 30988)
-- Name: payment_application payment_application_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payment_application
    ADD CONSTRAINT payment_application_pk_id PRIMARY KEY (id);


--
-- TOC entry 4873 (class 2606 OID 30996)
-- Name: payment_item payment_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payment_item
    ADD CONSTRAINT payment_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4875 (class 2606 OID 31004)
-- Name: payment_method_type payment_method_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payment_method_type
    ADD CONSTRAINT payment_method_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4869 (class 2606 OID 30980)
-- Name: payment payment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payment
    ADD CONSTRAINT payment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4877 (class 2606 OID 31014)
-- Name: payroll_preference payroll_preference_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.payroll_preference
    ADD CONSTRAINT payroll_preference_pk_id PRIMARY KEY (id);


--
-- TOC entry 4881 (class 2606 OID 31034)
-- Name: pharmacy_sales_item pharmacy_sales_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pharmacy_sales_item
    ADD CONSTRAINT pharmacy_sales_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4879 (class 2606 OID 31022)
-- Name: pharmacy_sales pharmacy_sales_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pharmacy_sales
    ADD CONSTRAINT pharmacy_sales_pk_id PRIMARY KEY (id);


--
-- TOC entry 4883 (class 2606 OID 31042)
-- Name: physical_characteristic physical_characteristic_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.physical_characteristic
    ADD CONSTRAINT physical_characteristic_pk_id PRIMARY KEY (id);


--
-- TOC entry 4887 (class 2606 OID 31059)
-- Name: pick_list_item pick_list_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pick_list_item
    ADD CONSTRAINT pick_list_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4885 (class 2606 OID 31050)
-- Name: pick_list pick_list_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pick_list
    ADD CONSTRAINT pick_list_pk_id PRIMARY KEY (id);


--
-- TOC entry 4889 (class 2606 OID 31066)
-- Name: pos_sales_order pos_sales_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.pos_sales_order
    ADD CONSTRAINT pos_sales_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 4893 (class 2606 OID 31082)
-- Name: position_fulfillment position_fulfillment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.position_fulfillment
    ADD CONSTRAINT position_fulfillment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4891 (class 2606 OID 31074)
-- Name: position position_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian."position"
    ADD CONSTRAINT position_pk_id PRIMARY KEY (id);


--
-- TOC entry 4895 (class 2606 OID 31091)
-- Name: position_reporting_structure position_reporting_structure_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.position_reporting_structure
    ADD CONSTRAINT position_reporting_structure_pk_id PRIMARY KEY (id);


--
-- TOC entry 4897 (class 2606 OID 31099)
-- Name: position_responsibility position_responsibility_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.position_responsibility
    ADD CONSTRAINT position_responsibility_pk_id PRIMARY KEY (id);


--
-- TOC entry 4899 (class 2606 OID 31107)
-- Name: position_type position_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.position_type
    ADD CONSTRAINT position_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 4901 (class 2606 OID 31116)
-- Name: position_type_rate position_type_rate_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.position_type_rate
    ADD CONSTRAINT position_type_rate_pk_id PRIMARY KEY (id);


--
-- TOC entry 4903 (class 2606 OID 31123)
-- Name: practitioner_provider_relationship practitioner_provider_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.practitioner_provider_relationship
    ADD CONSTRAINT practitioner_provider_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 4905 (class 2606 OID 31132)
-- Name: price_component price_component_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.price_component
    ADD CONSTRAINT price_component_pk_id PRIMARY KEY (id);


--
-- TOC entry 4911 (class 2606 OID 31157)
-- Name: product_category_classification product_category_classification_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_category_classification
    ADD CONSTRAINT product_category_classification_pk_id PRIMARY KEY (id);


--
-- TOC entry 4909 (class 2606 OID 31148)
-- Name: product_category product_category_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_category
    ADD CONSTRAINT product_category_pk_id PRIMARY KEY (id);


--
-- TOC entry 4913 (class 2606 OID 31164)
-- Name: product_code product_code_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_code
    ADD CONSTRAINT product_code_pk_id PRIMARY KEY (id);


--
-- TOC entry 4915 (class 2606 OID 31173)
-- Name: product_component product_component_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_component
    ADD CONSTRAINT product_component_pk_id PRIMARY KEY (id);


--
-- TOC entry 4917 (class 2606 OID 31182)
-- Name: product_cost product_cost_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_cost
    ADD CONSTRAINT product_cost_pk_id PRIMARY KEY (id);


--
-- TOC entry 4921 (class 2606 OID 31198)
-- Name: product_feature_applicability product_feature_applicability_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_feature_applicability
    ADD CONSTRAINT product_feature_applicability_pk_id PRIMARY KEY (id);


--
-- TOC entry 4919 (class 2606 OID 31190)
-- Name: product_feature product_feature_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_feature
    ADD CONSTRAINT product_feature_pk_id PRIMARY KEY (id);


--
-- TOC entry 4923 (class 2606 OID 31205)
-- Name: product_identification product_identification_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_identification
    ADD CONSTRAINT product_identification_pk_id PRIMARY KEY (id);


--
-- TOC entry 4907 (class 2606 OID 31140)
-- Name: product product_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product
    ADD CONSTRAINT product_pk_id PRIMARY KEY (id);


--
-- TOC entry 4925 (class 2606 OID 31215)
-- Name: product_price product_price_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_price
    ADD CONSTRAINT product_price_pk_id PRIMARY KEY (id);


--
-- TOC entry 4927 (class 2606 OID 31222)
-- Name: product_receivable product_receivable_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_receivable
    ADD CONSTRAINT product_receivable_pk_id PRIMARY KEY (id);


--
-- TOC entry 4929 (class 2606 OID 31230)
-- Name: product_requirement product_requirement_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_requirement
    ADD CONSTRAINT product_requirement_pk_id PRIMARY KEY (id);


--
-- TOC entry 4933 (class 2606 OID 31247)
-- Name: product_retur_item product_retur_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_retur_item
    ADD CONSTRAINT product_retur_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4931 (class 2606 OID 31238)
-- Name: product_retur product_retur_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_retur
    ADD CONSTRAINT product_retur_pk_id PRIMARY KEY (id);


--
-- TOC entry 4935 (class 2606 OID 31255)
-- Name: product_supplier product_supplier_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.product_supplier
    ADD CONSTRAINT product_supplier_pk_id PRIMARY KEY (id);


--
-- TOC entry 4937 (class 2606 OID 31264)
-- Name: production_info production_info_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.production_info
    ADD CONSTRAINT production_info_pk_id PRIMARY KEY (id);


--
-- TOC entry 4939 (class 2606 OID 31272)
-- Name: production_run_properties production_run_properties_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.production_run_properties
    ADD CONSTRAINT production_run_properties_pk_id PRIMARY KEY (id);


--
-- TOC entry 4941 (class 2606 OID 31279)
-- Name: purchase_invoice purchase_invoice_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_invoice
    ADD CONSTRAINT purchase_invoice_pk_id PRIMARY KEY (id);


--
-- TOC entry 4945 (class 2606 OID 31295)
-- Name: purchase_order_item purchase_order_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_item
    ADD CONSTRAINT purchase_order_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4943 (class 2606 OID 31286)
-- Name: purchase_order purchase_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order
    ADD CONSTRAINT purchase_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 4949 (class 2606 OID 31311)
-- Name: purchase_order_request_item purchase_order_request_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_request_item
    ADD CONSTRAINT purchase_order_request_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4947 (class 2606 OID 31302)
-- Name: purchase_order_request purchase_order_request_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_request
    ADD CONSTRAINT purchase_order_request_pk_id PRIMARY KEY (id);


--
-- TOC entry 4951 (class 2606 OID 31318)
-- Name: purchase_order_request_review purchase_order_request_review_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_request_review
    ADD CONSTRAINT purchase_order_request_review_pk_id PRIMARY KEY (id);


--
-- TOC entry 4953 (class 2606 OID 31325)
-- Name: purchase_order_request_role purchase_order_request_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_request_role
    ADD CONSTRAINT purchase_order_request_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4955 (class 2606 OID 31332)
-- Name: purchase_order_request_status purchase_order_request_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.purchase_order_request_status
    ADD CONSTRAINT purchase_order_request_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4957 (class 2606 OID 31342)
-- Name: quantity_break quantity_break_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quantity_break
    ADD CONSTRAINT quantity_break_pk_id PRIMARY KEY (id);


--
-- TOC entry 4959 (class 2606 OID 31352)
-- Name: quick_launch quick_launch_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quick_launch
    ADD CONSTRAINT quick_launch_pk_id PRIMARY KEY (id);


--
-- TOC entry 4963 (class 2606 OID 31370)
-- Name: quote_item quote_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quote_item
    ADD CONSTRAINT quote_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4961 (class 2606 OID 31360)
-- Name: quote quote_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quote
    ADD CONSTRAINT quote_pk_id PRIMARY KEY (id);


--
-- TOC entry 4965 (class 2606 OID 31378)
-- Name: quote_role quote_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quote_role
    ADD CONSTRAINT quote_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4967 (class 2606 OID 31387)
-- Name: quote_term quote_term_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.quote_term
    ADD CONSTRAINT quote_term_pk_id PRIMARY KEY (id);


--
-- TOC entry 4969 (class 2606 OID 31394)
-- Name: receipt receipt_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.receipt
    ADD CONSTRAINT receipt_pk_id PRIMARY KEY (id);


--
-- TOC entry 4971 (class 2606 OID 31402)
-- Name: receivable_order receivable_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.receivable_order
    ADD CONSTRAINT receivable_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 4973 (class 2606 OID 31409)
-- Name: recurring_payment recurring_payment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.recurring_payment
    ADD CONSTRAINT recurring_payment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4977 (class 2606 OID 31428)
-- Name: request_item request_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.request_item
    ADD CONSTRAINT request_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4975 (class 2606 OID 31418)
-- Name: request request_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.request
    ADD CONSTRAINT request_pk_id PRIMARY KEY (id);


--
-- TOC entry 4979 (class 2606 OID 31435)
-- Name: request_role request_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.request_role
    ADD CONSTRAINT request_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4983 (class 2606 OID 31453)
-- Name: requirement_order_commitment requirement_order_commitment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.requirement_order_commitment
    ADD CONSTRAINT requirement_order_commitment_pk_id PRIMARY KEY (id);


--
-- TOC entry 4981 (class 2606 OID 31444)
-- Name: requirement requirement_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.requirement
    ADD CONSTRAINT requirement_pk_id PRIMARY KEY (id);


--
-- TOC entry 4985 (class 2606 OID 31461)
-- Name: requirement_request requirement_request_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.requirement_request
    ADD CONSTRAINT requirement_request_pk_id PRIMARY KEY (id);


--
-- TOC entry 4987 (class 2606 OID 31468)
-- Name: requirement_role requirement_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.requirement_role
    ADD CONSTRAINT requirement_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4989 (class 2606 OID 31476)
-- Name: requirement_status requirement_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.requirement_status
    ADD CONSTRAINT requirement_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 4991 (class 2606 OID 31484)
-- Name: review review_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.review
    ADD CONSTRAINT review_pk_id PRIMARY KEY (id);


--
-- TOC entry 4993 (class 2606 OID 31491)
-- Name: role role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.role
    ADD CONSTRAINT role_pk_id PRIMARY KEY (id);


--
-- TOC entry 4995 (class 2606 OID 31500)
-- Name: roled roled_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.roled
    ADD CONSTRAINT roled_pk_id PRIMARY KEY (id);


--
-- TOC entry 4997 (class 2606 OID 31507)
-- Name: sales_invoice sales_invoice_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.sales_invoice
    ADD CONSTRAINT sales_invoice_pk_id PRIMARY KEY (id);


--
-- TOC entry 5001 (class 2606 OID 31521)
-- Name: sales_order_item sales_order_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.sales_order_item
    ADD CONSTRAINT sales_order_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 4999 (class 2606 OID 31514)
-- Name: sales_order sales_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.sales_order
    ADD CONSTRAINT sales_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 5003 (class 2606 OID 31530)
-- Name: sequence_number sequence_number_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.sequence_number
    ADD CONSTRAINT sequence_number_pk_id PRIMARY KEY (id);


--
-- TOC entry 5009 (class 2606 OID 31559)
-- Name: shipment_issuance_item shipment_issuance_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_issuance_item
    ADD CONSTRAINT shipment_issuance_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5007 (class 2606 OID 31549)
-- Name: shipment_issuance shipment_issuance_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_issuance
    ADD CONSTRAINT shipment_issuance_pk_id PRIMARY KEY (id);


--
-- TOC entry 5011 (class 2606 OID 31566)
-- Name: shipment_issuance_role shipment_issuance_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_issuance_role
    ADD CONSTRAINT shipment_issuance_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5013 (class 2606 OID 31775)
-- Name: shipment_item shipment_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_item
    ADD CONSTRAINT shipment_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5015 (class 2606 OID 31785)
-- Name: shipment_order shipment_order_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_order
    ADD CONSTRAINT shipment_order_pk_id PRIMARY KEY (id);


--
-- TOC entry 5005 (class 2606 OID 31541)
-- Name: shipment shipment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment
    ADD CONSTRAINT shipment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5019 (class 2606 OID 31805)
-- Name: shipment_receipt_item shipment_receipt_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_receipt_item
    ADD CONSTRAINT shipment_receipt_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5017 (class 2606 OID 31794)
-- Name: shipment_receipt shipment_receipt_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_receipt
    ADD CONSTRAINT shipment_receipt_pk_id PRIMARY KEY (id);


--
-- TOC entry 5021 (class 2606 OID 31813)
-- Name: shipment_receipt_role shipment_receipt_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_receipt_role
    ADD CONSTRAINT shipment_receipt_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5023 (class 2606 OID 31824)
-- Name: shipment_route_segment shipment_route_segment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_route_segment
    ADD CONSTRAINT shipment_route_segment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5025 (class 2606 OID 31832)
-- Name: shipment_status shipment_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipment_status
    ADD CONSTRAINT shipment_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 5027 (class 2606 OID 31840)
-- Name: shipping_document shipping_document_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.shipping_document
    ADD CONSTRAINT shipping_document_pk_id PRIMARY KEY (id);


--
-- TOC entry 5031 (class 2606 OID 31858)
-- Name: simple_invoice_clinic_item simple_invoice_clinic_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.simple_invoice_clinic_item
    ADD CONSTRAINT simple_invoice_clinic_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5029 (class 2606 OID 31849)
-- Name: simple_invoice_clinic simple_invoice_clinic_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.simple_invoice_clinic
    ADD CONSTRAINT simple_invoice_clinic_pk_id PRIMARY KEY (id);


--
-- TOC entry 5033 (class 2606 OID 31866)
-- Name: statuses statuses_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.statuses
    ADD CONSTRAINT statuses_pk_id PRIMARY KEY (id);


--
-- TOC entry 5037 (class 2606 OID 31883)
-- Name: stock_adjustment_item stock_adjustment_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_adjustment_item
    ADD CONSTRAINT stock_adjustment_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5035 (class 2606 OID 31874)
-- Name: stock_adjustment stock_adjustment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_adjustment
    ADD CONSTRAINT stock_adjustment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5039 (class 2606 OID 31890)
-- Name: stock_admin stock_admin_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_admin
    ADD CONSTRAINT stock_admin_pk_id PRIMARY KEY (id);


--
-- TOC entry 5041 (class 2606 OID 31900)
-- Name: stock_history stock_history_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_history
    ADD CONSTRAINT stock_history_pk_id PRIMARY KEY (id);


--
-- TOC entry 5045 (class 2606 OID 31917)
-- Name: stock_opname_item stock_opname_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_opname_item
    ADD CONSTRAINT stock_opname_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5043 (class 2606 OID 31908)
-- Name: stock_opname stock_opname_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.stock_opname
    ADD CONSTRAINT stock_opname_pk_id PRIMARY KEY (id);


--
-- TOC entry 5047 (class 2606 OID 31925)
-- Name: student student_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.student
    ADD CONSTRAINT student_pk_id PRIMARY KEY (id);


--
-- TOC entry 5049 (class 2606 OID 31932)
-- Name: student_relationship student_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.student_relationship
    ADD CONSTRAINT student_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 5051 (class 2606 OID 31947)
-- Name: study_day study_day_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.study_day
    ADD CONSTRAINT study_day_pk_id PRIMARY KEY (id);


--
-- TOC entry 5053 (class 2606 OID 31954)
-- Name: study_period study_period_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.study_period
    ADD CONSTRAINT study_period_pk_id PRIMARY KEY (id);


--
-- TOC entry 5055 (class 2606 OID 31962)
-- Name: study_room study_room_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.study_room
    ADD CONSTRAINT study_room_pk_id PRIMARY KEY (id);


--
-- TOC entry 5057 (class 2606 OID 31970)
-- Name: study_time study_time_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.study_time
    ADD CONSTRAINT study_time_pk_id PRIMARY KEY (id);


--
-- TOC entry 5059 (class 2606 OID 31977)
-- Name: supplier supplier_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.supplier
    ADD CONSTRAINT supplier_pk_id PRIMARY KEY (id);


--
-- TOC entry 5061 (class 2606 OID 31984)
-- Name: supplier_relationship supplier_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.supplier_relationship
    ADD CONSTRAINT supplier_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 5063 (class 2606 OID 31994)
-- Name: tax tax_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.tax
    ADD CONSTRAINT tax_pk_id PRIMARY KEY (id);


--
-- TOC entry 5065 (class 2606 OID 32002)
-- Name: term_type term_type_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.term_type
    ADD CONSTRAINT term_type_pk_id PRIMARY KEY (id);


--
-- TOC entry 5067 (class 2606 OID 32010)
-- Name: time_entry time_entry_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.time_entry
    ADD CONSTRAINT time_entry_pk_id PRIMARY KEY (id);


--
-- TOC entry 5069 (class 2606 OID 32018)
-- Name: timesheet timesheet_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.timesheet
    ADD CONSTRAINT timesheet_pk_id PRIMARY KEY (id);


--
-- TOC entry 5071 (class 2606 OID 32026)
-- Name: timesheet_role timesheet_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.timesheet_role
    ADD CONSTRAINT timesheet_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5075 (class 2606 OID 32041)
-- Name: transfer_order_request_item transfer_order_request_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.transfer_order_request_item
    ADD CONSTRAINT transfer_order_request_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5073 (class 2606 OID 32033)
-- Name: transfer_order_request transfer_order_request_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.transfer_order_request
    ADD CONSTRAINT transfer_order_request_pk_id PRIMARY KEY (id);


--
-- TOC entry 5079 (class 2606 OID 32061)
-- Name: treatment_item treatment_item_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.treatment_item
    ADD CONSTRAINT treatment_item_pk_id PRIMARY KEY (id);


--
-- TOC entry 5077 (class 2606 OID 32049)
-- Name: treatment treatment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.treatment
    ADD CONSTRAINT treatment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5081 (class 2606 OID 32069)
-- Name: unit_of_measure unit_of_measure_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.unit_of_measure
    ADD CONSTRAINT unit_of_measure_pk_id PRIMARY KEY (id);


--
-- TOC entry 5083 (class 2606 OID 32077)
-- Name: uom_factor uom_factor_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.uom_factor
    ADD CONSTRAINT uom_factor_pk_id PRIMARY KEY (id);


--
-- TOC entry 5087 (class 2606 OID 32096)
-- Name: user_role user_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.user_role
    ADD CONSTRAINT user_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5089 (class 2606 OID 32104)
-- Name: user_setting user_setting_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.user_setting
    ADD CONSTRAINT user_setting_pk_id PRIMARY KEY (id);


--
-- TOC entry 5093 (class 2606 OID 32126)
-- Name: work_effort_asset_assignment work_effort_asset_assignment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_asset_assignment
    ADD CONSTRAINT work_effort_asset_assignment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5095 (class 2606 OID 32134)
-- Name: work_effort_deliverable_produced work_effort_deliverable_produced_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_deliverable_produced
    ADD CONSTRAINT work_effort_deliverable_produced_pk_id PRIMARY KEY (id);


--
-- TOC entry 5097 (class 2606 OID 32143)
-- Name: work_effort_info work_effort_info_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_info
    ADD CONSTRAINT work_effort_info_pk_id PRIMARY KEY (id);


--
-- TOC entry 5099 (class 2606 OID 32152)
-- Name: work_effort_inventory_assignment work_effort_inventory_assignment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_inventory_assignment
    ADD CONSTRAINT work_effort_inventory_assignment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5101 (class 2606 OID 32160)
-- Name: work_effort_inventorys_produced work_effort_inventorys_produced_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_inventorys_produced
    ADD CONSTRAINT work_effort_inventorys_produced_pk_id PRIMARY KEY (id);


--
-- TOC entry 5103 (class 2606 OID 32170)
-- Name: work_effort_party_assignment work_effort_party_assignment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_party_assignment
    ADD CONSTRAINT work_effort_party_assignment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5105 (class 2606 OID 32179)
-- Name: work_effort_party_rate work_effort_party_rate_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_party_rate
    ADD CONSTRAINT work_effort_party_rate_pk_id PRIMARY KEY (id);


--
-- TOC entry 5091 (class 2606 OID 32116)
-- Name: work_effort work_effort_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort
    ADD CONSTRAINT work_effort_pk_id PRIMARY KEY (id);


--
-- TOC entry 5107 (class 2606 OID 32187)
-- Name: work_effort_role work_effort_role_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_role
    ADD CONSTRAINT work_effort_role_pk_id PRIMARY KEY (id);


--
-- TOC entry 5109 (class 2606 OID 32195)
-- Name: work_effort_status work_effort_status_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_effort_status
    ADD CONSTRAINT work_effort_status_pk_id PRIMARY KEY (id);


--
-- TOC entry 5111 (class 2606 OID 32203)
-- Name: work_order_item_fulfillment work_order_item_fulfillment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_order_item_fulfillment
    ADD CONSTRAINT work_order_item_fulfillment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5115 (class 2606 OID 32220)
-- Name: work_requirement_fulfillment work_requirement_fulfillment_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_requirement_fulfillment
    ADD CONSTRAINT work_requirement_fulfillment_pk_id PRIMARY KEY (id);


--
-- TOC entry 5113 (class 2606 OID 32212)
-- Name: work_requirement work_requirement_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.work_requirement
    ADD CONSTRAINT work_requirement_pk_id PRIMARY KEY (id);


--
-- TOC entry 5117 (class 2606 OID 32227)
-- Name: worker worker_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.worker
    ADD CONSTRAINT worker_pk_id PRIMARY KEY (id);


--
-- TOC entry 5119 (class 2606 OID 32234)
-- Name: worker_relationship worker_relationship_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.worker_relationship
    ADD CONSTRAINT worker_relationship_pk_id PRIMARY KEY (id);


--
-- TOC entry 5121 (class 2606 OID 32243)
-- Name: working_shift working_shift_pk_id; Type: CONSTRAINT; Schema: belian; Owner: belian
--

ALTER TABLE ONLY belian.working_shift
    ADD CONSTRAINT working_shift_pk_id PRIMARY KEY (id);


-- Completed on 2024-05-22 19:29:40

--
-- PostgreSQL database dump complete
--

