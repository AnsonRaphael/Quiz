import React from 'react';
import PropTypes from 'prop-types';
import { Route, Redirect } from 'react-router-dom';

function CustomRoute(props) {
    const { restricted, ...rest } = props;
    if (restricted) {
        /**
         * @todo test privilege from store and redirect if no privilege
         */
        return <Redirect to='/access-denied' />
    }
    return <Route {...rest} />;
}

CustomRoute.defaultProps = {
    restricted: false,
    privilege: '',
};

CustomRoute.propTypes = {
    restricted: PropTypes.bool,
    privilege: PropTypes.string,
};

export default CustomRoute;

