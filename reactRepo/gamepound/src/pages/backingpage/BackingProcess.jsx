import React from 'react';
import styled from 'styled-components';
import BackingDetails from './BackingDetails';
import PaymentCheck from './PaymentCheck';

const StyledBackingProcessDiv = styled.div`
    width: 1200px;
    display: flex;
    justify-content: center;
`;

const BackingProcessDetails = () => {
    return (
        <StyledBackingProcessDiv>
            <BackingDetails />
            <PaymentCheck />
        </StyledBackingProcessDiv>
    );
};

export default BackingProcessDetails;