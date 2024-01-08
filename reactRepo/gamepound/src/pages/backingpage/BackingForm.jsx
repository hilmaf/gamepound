import React from 'react';
import styled from 'styled-components';
import BackingDetails from './BackingDetails';
import PaymentCheck from './PaymentCheck';

const StyledBackingFormDiv = styled.div`
    width: 1200px;
    display: flex;
    justify-content: center;
`;

const BackingForm = () => {
    return (
        <StyledBackingFormDiv>
            <BackingDetails/>
            <PaymentCheck/>
        </StyledBackingFormDiv>
    );
};

export default BackingForm;